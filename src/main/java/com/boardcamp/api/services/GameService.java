package com.boardcamp.api.services;

import com.boardcamp.api.dtos.GameDTO;
import com.boardcamp.api.exceptions.GameNameConflictException;
import com.boardcamp.api.models.GameModel;
import com.boardcamp.api.repositories.GameRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GameService {

  final GameRepository gameRepository;

  GameService(GameRepository gameRepository) {
    this.gameRepository = gameRepository;
  }

  public GameModel save(GameDTO gameDTO) {
    if (gameRepository.existsByName(gameDTO.getName())) {
      throw new GameNameConflictException("Game already exists");
    }

    GameModel game = new GameModel(gameDTO);
    return gameRepository.save(game);
  }

  public List<GameModel> findAll() {
    return gameRepository.findAll();
  }
}
