package com.katusoft.api.controller;

import com.katusoft.api.dto.CreateUserRequest;
import com.katusoft.api.dto.UserResponse;
import com.katusoft.model.user.User;
import com.katusoft.usecase.createuser.CreateUserCommand;
import com.katusoft.usecase.createuser.CreateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final CreateUserUseCase createUserUseCase;

  public AuthController(CreateUserUseCase createUserUseCase) {
    this.createUserUseCase = createUserUseCase;
  }

  @PostMapping("/register")
  public ResponseEntity<UserResponse> register (@Valid @RequestBody CreateUserRequest request) {
    CreateUserCommand command = new CreateUserCommand(
        request.getUsername(),
        request.getEmail(),
        request.getPassword()
    );

    User user = createUserUseCase.execute(command);

    return ResponseEntity.ok(new UserResponse(user));
  }
}
