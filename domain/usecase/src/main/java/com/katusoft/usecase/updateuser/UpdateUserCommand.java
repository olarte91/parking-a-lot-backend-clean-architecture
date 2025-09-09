package com.katusoft.usecase.updateuser;

import java.util.UUID;

public class UpdateUserCommand {

  private final UUID id;
  private final String username;
  private final String email;
  private final String password;

  public UpdateUserCommand(UUID id, String username, String email, String password) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public UUID getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }
}
