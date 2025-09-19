package com.katusoft.model.authentication.gateways;

public interface PasswordService {
  boolean matches(String rawPassword, String encodedPassword);
  String encode(String rawPassword);
}
