package com.katusoft.model.exception;

public class ParkingSpaceAlreadyOccupiedException extends RuntimeException {
  public ParkingSpaceAlreadyOccupiedException(String message) {
    super(message);
  }
}
