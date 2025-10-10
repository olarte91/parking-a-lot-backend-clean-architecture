package com.katusoft.model.exception;

public class VehicleAlreadyExistsException extends RuntimeException {
  public VehicleAlreadyExistsException(String message) {
    super(message);
  }
}
