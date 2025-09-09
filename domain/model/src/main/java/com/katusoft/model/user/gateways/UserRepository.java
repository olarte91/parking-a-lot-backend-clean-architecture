package com.katusoft.model.user.gateways;

import com.katusoft.model.user.User;

import java.util.UUID;

public interface UserRepository {
  boolean findByEmail(String email);
  boolean findByUsername(String username);
  boolean findUserById(UUID id);
  User createUser(User user);
  User updateUser(User user);
  void deleteUser(UUID userId);
}
