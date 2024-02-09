package com.boardcamp.api.exceptions;

public class CustomerCPFConflictException extends RuntimeException {
  public CustomerCPFConflictException(String message) {
    super(message);
  }
}
