package com.katusoft.model.user.gateways;

import com.katusoft.model.user.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
  boolean findByEmail(String email);
  boolean findByUsername(String username);
  Optional<User> findUserByUsername(String username);
  Optional<User> findUserById(UUID id);
  User createUser(User user);
  User updateUser(User user);
  void deleteUser(UUID userId);
}
