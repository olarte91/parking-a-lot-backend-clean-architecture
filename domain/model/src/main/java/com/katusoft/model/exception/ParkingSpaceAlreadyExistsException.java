package com.katusoft.model.exception;

public class ParkingSpaceAlreadyExistsException extends RuntimeException {
  public ParkingSpaceAlreadyExistsException(String message) {
    super(message);
  }
}
