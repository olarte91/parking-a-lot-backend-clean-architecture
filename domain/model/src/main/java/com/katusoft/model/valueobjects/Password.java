package com.katusoft.model.valueobjects;

import com.katusoft.model.exception.InvalidPasswordException;

import java.util.Objects;

public class Password {

  private final String value;


  public Password(String value) {
    validate(value);
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  private void validate(String value) {
    if(value == null || value.isEmpty()) {
      throw new InvalidPasswordException("The password cannot be null or empty");
    }
  }

  @Override
  public boolean equals(Object obj){
    if(this == obj) return true;
    if(obj == null || getClass() != obj.getClass()) return false;
    Password password = (Password) obj;
    return Objects.equals(value, password.value);
  }

  @Override
  public int hashCode(){
    return Objects.hash(value);
  }
}
