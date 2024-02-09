package com.boardcamp.api.repositories;

import com.boardcamp.api.models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameModel, Long> {
  boolean existsByName(String name);
}
