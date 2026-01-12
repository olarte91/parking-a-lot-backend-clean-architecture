package com.katusoft.model.exception;

public class FareNotConfiguredException extends DomainException {
  public FareNotConfiguredException(String message) {
    super("500", message);
  }
}
