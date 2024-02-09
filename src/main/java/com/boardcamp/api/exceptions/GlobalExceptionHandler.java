package com.boardcamp.api.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalExceptionHandler {

  // Customers

  @ExceptionHandler({ CustomerCPFConflictException.class })
  public ResponseEntity<String> handlerCustomerCPFConflict(CustomerCPFConflictException e) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
  }

  @ExceptionHandler({ CustomerNotFoundException.class })
  public ResponseEntity<String> handlerCustomerNotFound(CustomerNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
  }

  // Games

  @ExceptionHandler({ GameNameConflictException.class })
  public ResponseEntity<String> handlerGameNameConflict(GameNameConflictException e) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
  }

  @ExceptionHandler({ GameNotFoundException.class })
  public ResponseEntity<String> handleGameNotFound(GameNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
  }

  @ExceptionHandler({ GameNotInStockException.class })
  public ResponseEntity<String> handleGameNotInStock(GameNotInStockException e) {
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
  }

  // Rentals

  @ExceptionHandler({ RentalNotFoundException.class })
  public ResponseEntity<String> handleRentalNotFound(RentalNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
  }

  @ExceptionHandler({ RentalAlreadyReturnedException.class })
  public ResponseEntity<String> handleRentalAlreadyReturned(RentalAlreadyReturnedException e) {
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
  }

}
