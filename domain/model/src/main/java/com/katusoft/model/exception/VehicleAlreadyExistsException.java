package com.katusoft.model.exception;

public class VehicleAlreadyExistsException extends DomainException {
  public VehicleAlreadyExistsException(String message) {
    super("409", message);
  }
}
