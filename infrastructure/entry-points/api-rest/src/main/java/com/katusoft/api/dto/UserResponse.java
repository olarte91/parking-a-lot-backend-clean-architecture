package com.katusoft.api.dto;

import com.katusoft.model.user.User;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserResponse {

  private UUID id;
  private String username;
  private String email;

  public UserResponse(User user){
    this.id = user.getId();
    this.username = user.getUsername();
    this.email = user.getEmail();
  }
}
