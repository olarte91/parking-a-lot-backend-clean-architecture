package com.katusoft.model.exception;

public class UserAlreadyExistsException extends DomainException {
  public UserAlreadyExistsException(String message) {
    super(message);
  }
}
