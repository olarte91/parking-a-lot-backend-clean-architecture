package com.katusoft.api.dto;

import com.katusoft.model.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

  private String username;
  private String email;
  private String token;

  public UserResponse(User user, String token){
    this.username = user.getUsername();
    this.email = user.getEmail();
    this.token = token;
  }
}
