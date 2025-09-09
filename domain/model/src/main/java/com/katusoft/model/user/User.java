package com.katusoft.model.user;

import com.katusoft.model.valueobjects.Email;
import com.katusoft.model.valueobjects.Password;
import com.katusoft.model.valueobjects.Username;

import java.util.Objects;
import java.util.UUID;

public class User {
  private UUID id;
  private Username username;
  private Email email;
  private Password password;

  public User (){}

  public User(UUID id, String username, String email, String password) {
    this.id = id;
    this.username = new Username(username);
    this.email = new Email(email);
    this.password = new Password(password);
  }

  public UUID getId() {
    return id;
  }

  public String getUsername() {
    return username.getValue();
  }

  public void setUsername(String username) {
    this.username = new Username(username);
  }

  public String getEmail() {
    return email.getValue();
  }

  public void setEmail(String email) {
    this.email = new Email(email);
  }

  public String getPassword() {
    return password.getValue();
  }

  public void setPassword(String password) {
    this.password = new Password(password);
  }

  @Override
  public boolean equals(Object obj){
    if(this == obj) return true;
    if(obj == null || getClass() != obj.getClass()) return false;
    User user = (User)obj;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode(){
    return Objects.hash(id);
  }
}
