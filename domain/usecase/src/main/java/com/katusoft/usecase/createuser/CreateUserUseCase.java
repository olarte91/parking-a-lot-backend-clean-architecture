package com.katusoft.usecase.createuser;

import com.katusoft.model.exception.UserAlreadyExistsException;
import com.katusoft.model.user.User;
import com.katusoft.model.user.gateways.UserRepository;

import java.util.UUID;

public class CreateUserUseCase {

  private final UserRepository userRepository;

  public CreateUserUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User execute(CreateUserCommand command){
    if(userRepository.findByUsername(command.getUsername())){
      throw new UserAlreadyExistsException("The user " + command.getUsername() + " already exists");
    }
    if(userRepository.findByEmail(command.getEmail())){
      throw new UserAlreadyExistsException("The user with email: " + command.getEmail() + " already exists");
    }

    User user =  new User(UUID.randomUUID(), command.getUsername(), command.getEmail(), command.getPassword());

    return userRepository.createUser(user);
  }
}
