package com.boardcamp.api.services;

import com.boardcamp.api.dtos.RentalDTO;
import com.boardcamp.api.exceptions.CustomerNotFoundException;
import com.boardcamp.api.exceptions.GameNotFoundException;
import com.boardcamp.api.exceptions.GameNotInStockException;
import com.boardcamp.api.exceptions.RentalAlreadyReturnedException;
import com.boardcamp.api.exceptions.RentalNotFoundException;
import com.boardcamp.api.models.CustomerModel;
import com.boardcamp.api.models.GameModel;
import com.boardcamp.api.models.RentalModel;
import com.boardcamp.api.repositories.CustomerRepository;
import com.boardcamp.api.repositories.GameRepository;
import com.boardcamp.api.repositories.RentalRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

  LocalDate today = LocalDate.now();

  final RentalRepository rentalRepository;
  final CustomerRepository customerRepository;
  final GameRepository gameRepository;

  RentalService(RentalRepository rentalRepository, CustomerRepository customerRepository,
      GameRepository gameRepository) {
    this.rentalRepository = rentalRepository;
    this.customerRepository = customerRepository;
    this.gameRepository = gameRepository;
  }

  public List<RentalModel> findAll() {
    return rentalRepository.findAll();
  }

  public RentalModel save(RentalDTO rentalDTO) {
    Optional<GameModel> gameExists = gameRepository.findById(rentalDTO.getGameId());
    if (gameExists.isEmpty()) {
      throw new GameNotFoundException("Game not found");
    }

    Optional<CustomerModel> customerExists = customerRepository.findById(rentalDTO.getCustomerId());
    if (customerExists.isEmpty()) {
      throw new CustomerNotFoundException("Customer not found");
    }

    GameModel game = gameExists.get();
    CustomerModel customer = customerExists.get();

    if (game.getStockTotal() <= 0) {
      throw new GameNotInStockException("Game not in stock");
    }

    game.setStockTotal(game.getStockTotal() - 1);

    int originalPrice = game.getPricePerDay() * rentalDTO.getDaysRented();

    RentalModel rental = new RentalModel(rentalDTO, today, originalPrice, customer, game);
    return rentalRepository.save(rental);
  }

  public RentalModel update(Long id) {
    Optional<RentalModel> rentalExists = rentalRepository.findById(id);
    if (rentalExists.isEmpty()) {
      throw new RentalNotFoundException("Rental not found");
    }

    RentalModel rental = rentalExists.get();
    if (rental.getReturnDate() != null) {
      throw new RentalAlreadyReturnedException("Rental already returned");
    }

    rental.setReturnDate(today);
    rental.getGame().setStockTotal(rental.getGame().getStockTotal() + 1);

    long daysRented = rental.getReturnDate().toEpochDay() - rental.getRentDate().toEpochDay();
    int lateDays = (int) (daysRented - rental.getDaysRented());

    if (lateDays > 0) {
      rental.setDelayFee(lateDays * rental.getGame().getPricePerDay());
    }

    return rentalRepository.save(new RentalModel(rental, today, rental.getDelayFee()));
  }

}
