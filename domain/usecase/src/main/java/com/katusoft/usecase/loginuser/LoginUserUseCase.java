package com.katusoft.usecase.loginuser;

import com.katusoft.model.authentication.gateways.PasswordService;
import com.katusoft.model.authentication.gateways.TokenService;
import com.katusoft.model.exception.InvalidCredentialsException;
import com.katusoft.model.user.User;
import com.katusoft.model.user.gateways.UserRepository;

public class LoginUserUseCase {

  private final UserRepository userRepository;
  private final PasswordService passwordService;
  private final TokenService tokenService;

  public LoginUserUseCase(UserRepository userRepository, PasswordService passwordService, TokenService tokenService) {
    this.userRepository = userRepository;
    this.passwordService = passwordService;
    this.tokenService = tokenService;
  }

  public String execute(LoginCommand command){
    User user = userRepository.findUserByUsername(command.getUsername())
        .orElseThrow(() -> new InvalidCredentialsException("Invalid Credentials"));

    if(!passwordService.matches(command.getPassword(), user.getPassword())){
      throw new InvalidCredentialsException("Invalid Credentials");
    }

    return tokenService.generateToken(user);
  }
}
