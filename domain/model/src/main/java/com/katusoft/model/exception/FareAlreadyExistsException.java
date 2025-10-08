package com.katusoft.model.exception;

public class FareAlreadyExistsException extends RuntimeException {
  public FareAlreadyExistsException(String message) {
    super(message);
  }
}
