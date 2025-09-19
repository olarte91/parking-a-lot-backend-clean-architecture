package com.katusoft.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@EnableMethodSecurity
@RequestMapping("/api/test")
public class TestController {

  @GetMapping("/protected")
  public ResponseEntity<String> protectedEndpoint(Authentication authentication) {
      return ResponseEntity.ok("Hola " + authentication.getName() + " El JWT funciona correctamente");
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<String> adminEndpoint() {
    return ResponseEntity.ok("Hola admin");
  }

  @GetMapping("/user-info")
  public ResponseEntity<?> getCurrentUserInfo(Authentication authentication) {
    Map<String, Object> info = new HashMap<>();
    info.put("username", authentication.getName());
    info.put("authorities", authentication.getAuthorities());
    info.put("roles", authentication.getAuthorities().stream()
        .map(auth -> auth.getAuthority())
        .collect(Collectors.toList()));
    info.put("authenticated", authentication.isAuthenticated());

    return ResponseEntity.ok(info);
  }
}
