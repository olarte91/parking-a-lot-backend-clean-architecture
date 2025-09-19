package com.katusoft.model.user;

import com.katusoft.model.valueobjects.Email;
import com.katusoft.model.valueobjects.Password;
import com.katusoft.model.valueobjects.Role;
import com.katusoft.model.valueobjects.Username;

import java.util.Objects;
import java.util.UUID;

public class User {
  private UUID id;
  private Username username;
  private Email email;
  private Password password;
  private Role role;

  public User (){}

  //Constructor con role por defecto
  public User(UUID id, String username, String email, String password) {
    this.id = id;
    this.username = new Username(username);
    this.email = new Email(email);
    this.password = new Password(password);
    this.role = Role.user();
  }

  //Constructor completo con role
  public User(UUID id, String username, String email, String password, String role) {
    this.id = id;
    this.username = new Username(username);
    this.email = new Email(email);
    this.password = new Password(password);
    this.role = new Role(role);
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

  public String getRole() {
    return role.getValue();
  }

  public void setRole(String role) {
    this.role = new Role(role);
  }

  //Métodos de conveniencia
  public boolean isAdmin(){
    return role.isAdmin();
  }

  public boolean isUser(){
    return role.isUser();
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
