package com.boardcamp.api.exceptions;

public class GameNotInStockException extends RuntimeException {
  public GameNotInStockException(String message) {
    super(message);
  }
}
