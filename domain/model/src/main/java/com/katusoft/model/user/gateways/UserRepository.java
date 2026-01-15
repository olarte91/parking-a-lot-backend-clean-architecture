package com.katusoft.model.user.gateways;

import com.katusoft.model.user.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
  boolean existsByEmail(String email);
  boolean existsByUsername(String username);
  Optional<User> findUserByUsername(String username);
  Optional<User> findUserById(UUID id);
  User save(User user);
}
