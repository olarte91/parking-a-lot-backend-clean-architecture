package com.katusoft.model.valueobjects;

import com.katusoft.model.exception.InvalidUsernameException;

import java.util.Objects;

public class Username {

  private final String value;

  public Username(String value){
    validate(value);
    this.value = value;
  }

  private void validate(String username){
    if(username == null || username.trim().isEmpty()){
      throw new InvalidUsernameException("Username cannot be null or empty");
    }
    if(username.length() < 3 || username.length() > 20){
      throw new InvalidUsernameException("Username length must be between 3 and 20 characters");
    }
    if(!username.matches("^[a-zA-Z0-9_]+$")){
      throw new InvalidUsernameException("Username can only contain letters, numbers and underscores");
    }
  }

  public String getValue(){
    return value;
  }

  @Override
  public boolean equals(Object obj){
    if(this == obj) return true;
    if(obj == null || getClass() != obj.getClass()) return false;
    Username username = (Username)obj;
    return Objects.equals(value, username.value);
  }

  @Override
  public int hashCode(){
    return Objects.hash(value);
  }
}

