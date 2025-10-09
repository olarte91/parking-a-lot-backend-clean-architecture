package com.katusoft.api.controller;

import com.katusoft.api.dto.AuthResponse;
import com.katusoft.api.dto.CreateUserRequest;
import com.katusoft.api.dto.LoginRequest;
import com.katusoft.api.dto.UserResponse;
import com.katusoft.model.authentication.gateways.PasswordService;
import com.katusoft.model.authentication.gateways.TokenService;
import com.katusoft.model.user.User;
import com.katusoft.usecase.createuser.CreateUserCommand;
import com.katusoft.usecase.createuser.CreateUserUseCase;
import com.katusoft.usecase.loginuser.LoginCommand;
import com.katusoft.usecase.loginuser.LoginUserUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/auth")
public class AuthController {

  private final CreateUserUseCase createUserUseCase;
  private final LoginUserUseCase loginUserUseCase;
  private final TokenService tokenService;

  public AuthController(CreateUserUseCase createUserUseCase, LoginUserUseCase loginUserUseCase, TokenService tokenService) {
    this.createUserUseCase = createUserUseCase;
    this.loginUserUseCase = loginUserUseCase;
    this.tokenService = tokenService;
  }

  @PostMapping("/register")
  public ResponseEntity<UserResponse> register (@Valid @RequestBody CreateUserRequest request) {
    CreateUserCommand command = new CreateUserCommand(
        request.getUsername(),
        request.getEmail(),
        request.getPassword()
    );

    User user = createUserUseCase.execute(command);

    String token = tokenService.generateToken(user);

    return ResponseEntity.ok(new UserResponse(user, token));
  }


  @PostMapping("/login")
  public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
    LoginCommand command = new LoginCommand(request.getUsername(), request.getPassword());
    String token = loginUserUseCase.execute(command);

    AuthResponse response = new AuthResponse(
        token,
        request.getUsername(),
        LocalDateTime.now().plusHours(24)
    );

    return ResponseEntity.ok(response);
  }
}
