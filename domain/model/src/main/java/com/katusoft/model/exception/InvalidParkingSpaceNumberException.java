package com.katusoft.model.exception;

public class InvalidParkingSpaceNumberException extends DomainException {
  public InvalidParkingSpaceNumberException(String message) {
    super(message, "PARKING SPACE NUMBER OUT OF RANGE");
  }
}
