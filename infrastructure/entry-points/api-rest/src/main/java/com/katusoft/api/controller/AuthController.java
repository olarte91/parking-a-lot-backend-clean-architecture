package com.katusoft.api.controller;

import com.katusoft.api.dto.CreateUserRequest;
import com.katusoft.api.dto.UserResponse;
import com.katusoft.model.user.User;
import com.katusoft.usecase.createuser.CreateUserCommand;
import com.katusoft.usecase.createuser.CreateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final CreateUserUseCase createUserUseCase;
  private final PasswordEncoder passwordEncoder;

  public AuthController(CreateUserUseCase createUserUseCase, PasswordEncoder passwordEncoder) {
    this.createUserUseCase = createUserUseCase;
    this.passwordEncoder = passwordEncoder;
  }

  @PostMapping("/register")
  public ResponseEntity<UserResponse> register (@Valid @RequestBody CreateUserRequest request) {
    CreateUserCommand command = new CreateUserCommand(
        request.getUsername(),
        request.getEmail(),
        passwordEncoder.encode(request.getPassword())
    );

    User user = createUserUseCase.execute(command);

    return ResponseEntity.ok(new UserResponse(user));
  }

//  @GetMapping("/users")
//  public ResponseEntity<List<UserResponse>> getAllUsers() {
//    return ResponseEntity.ok()
//  }
}
