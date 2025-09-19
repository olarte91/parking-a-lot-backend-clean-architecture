package com.katusoft.usecase.loginuser;

public class LoginCommand {
  private final String username;
  private final String password;

  public LoginCommand(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }
  public String getPassword() {
    return password;
  }
}
