package com.katusoft.model.authentication.gateways;

import com.katusoft.model.user.User;

public interface TokenService {
  String generateToken(User user);
  String extractUsername(String token);
  boolean isTokenValid(String token, String username);

}
