package com.katusoft.model.exception;

public class VehicleNotRegisteredException extends DomainException {
  public VehicleNotRegisteredException(String message) {
    super("404", message);
  }
}
