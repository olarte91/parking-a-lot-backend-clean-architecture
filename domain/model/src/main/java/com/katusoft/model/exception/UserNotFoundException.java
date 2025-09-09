package com.katusoft.model.exception;

public class UserNotFoundException extends DomainException {
  public UserNotFoundException(String message) {
    super(message);
  }
}
