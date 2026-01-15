package com.katusoft.usecase.createuser;

import com.katusoft.model.authentication.gateways.PasswordService;
import com.katusoft.model.exception.UserAlreadyExistsException;
import com.katusoft.model.user.User;
import com.katusoft.model.user.gateways.UserRepository;

import java.util.UUID;

public class CreateUserUseCase {

  private final UserRepository userRepository;
  private final PasswordService passwordEncoder;

  public CreateUserUseCase(UserRepository userRepository, PasswordService passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User execute(CreateUserCommand command){
    if(userRepository.existsByUsername(command.getUsername())){
      throw new UserAlreadyExistsException("The user " + command.getUsername() + " already exists");
    }
    if(userRepository.existsByEmail(command.getEmail())){
      throw new UserAlreadyExistsException("The user with email: " + command.getEmail() + " already exists");
    }

    String encodedPassword = passwordEncoder.encode(command.getPassword());
    User user =  new User(UUID.randomUUID(), command.getUsername(), command.getEmail(), encodedPassword);

    return userRepository.save(user);
  }
}
