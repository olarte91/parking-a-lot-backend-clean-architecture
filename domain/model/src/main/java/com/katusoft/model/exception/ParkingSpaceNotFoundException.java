package com.katusoft.model.exception;

public class ParkingSpaceNotFoundException extends DomainException {
  public ParkingSpaceNotFoundException(String message) {
    super(message, "Parking Space Not Found");
  }
}
