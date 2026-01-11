package com.katusoft.model.exception;

public class IncompatibleVehicleTypeException extends DomainException {
  public IncompatibleVehicleTypeException(String message) {
    super(message, "Vehicle Type is incompatible");
  }
}
