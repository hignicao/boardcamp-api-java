package com.boardcamp.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

import com.boardcamp.api.dtos.RentalDTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rentals")
public class RentalModel {

  public RentalModel(RentalDTO rentalDTO) {
    this.customer = new CustomerModel();
    this.customer.setId(rentalDTO.getCustomerId());
    this.game = new GameModel();
    this.game.setId(rentalDTO.getGameId());
    this.daysRented = rentalDTO.getDaysRented();
  }

  public RentalModel(RentalDTO rentalDTO, LocalDate rentDate, int originalPrice, CustomerModel customer,
      GameModel game) {
    this.customer = customer;
    this.game = game;
    this.daysRented = rentalDTO.getDaysRented();
    this.rentDate = rentDate;
    this.returnDate = null;
    this.originalPrice = originalPrice;
    this.delayFee = 0;
  }

  public RentalModel(RentalModel rental, LocalDate returnDate, int delayFee) {
    this.id = rental.getId();
    this.customer = rental.getCustomer();
    this.game = rental.getGame();
    this.daysRented = rental.getDaysRented();
    this.rentDate = rental.getRentDate();
    this.returnDate = returnDate;
    this.originalPrice = rental.getOriginalPrice();
    this.delayFee = delayFee;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "customerId")
  private CustomerModel customer;

  @ManyToOne
  @JoinColumn(name = "gameId")
  private GameModel game;

  @Column(nullable = false)
  private LocalDate rentDate;

  @Column(nullable = false)
  private int daysRented;

  @Column(nullable = true)
  private LocalDate returnDate;

  @Column(nullable = false)
  private int originalPrice;

  @Column(nullable = false)
  private int delayFee;
}
