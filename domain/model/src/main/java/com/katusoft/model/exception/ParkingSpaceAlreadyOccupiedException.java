package com.katusoft.model.exception;

public class ParkingSpaceAlreadyOccupiedException extends DomainException {
  public ParkingSpaceAlreadyOccupiedException(String message) {
    super(message, "PARKINGSPACE ALREADY OCCUPIED");
  }
}
