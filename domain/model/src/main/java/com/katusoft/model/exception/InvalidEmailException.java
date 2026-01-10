package com.katusoft.model.exception;

public class InvalidEmailException extends DomainException {
  public InvalidEmailException(String message) {
    super(message, "INVALID EMAIL ADDRESS");
  }
}
