package com.katusoft.model.exception;

public class ParkingSpaceAlreadyAvailableException extends RuntimeException {
  public ParkingSpaceAlreadyAvailableException(String message) {
    super(message);
  }
}
