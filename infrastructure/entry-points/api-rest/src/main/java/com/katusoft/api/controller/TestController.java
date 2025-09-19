package com.katusoft.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
}
