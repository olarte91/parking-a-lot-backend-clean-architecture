package com.katusoft.model.exception;

public class FareNotFoundException extends RuntimeException {
  public FareNotFoundException(String message) {
    super(message);
  }
}
