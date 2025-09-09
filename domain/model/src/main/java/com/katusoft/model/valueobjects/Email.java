package com.katusoft.model.valueobjects;

import com.katusoft.model.exception.InvalidEmailException;

import java.util.Objects;

public class Email {

  private final String value;

  public Email(String value){
    validate(value);
    this.value = value;
  }

  public String getValue(){
    return value;
  }

  private void validate(String value){
    if(value == null || value.trim().isEmpty()){
        throw new InvalidEmailException("Email cannot be empty");
    }
    if(!value.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
      throw new InvalidEmailException("Invalid email format");
    }
  }

  @Override
  public boolean equals(Object obj){
    if(this == obj) return true;
    if(obj == null || getClass() != obj.getClass()) return false;
    Email email = (Email)obj;
    return Objects.equals(value, email.value);
  }

  @Override
  public int hashCode(){
    return Objects.hash(value);
  }
}
