package com.katusoft.usecase.updateuser;

import com.katusoft.model.exception.UserAlreadyExistsException;
import com.katusoft.model.exception.UserNotFoundException;
import com.katusoft.model.user.User;
import com.katusoft.model.user.gateways.UserRepository;


public class UpdateUserUseCase {

  private final UserRepository userRepository;

  public UpdateUserUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

//  public User execute(UpdateUserCommand command){
//    if(!userRepository.findUserById(command.getId())){
//      throw new UserNotFoundException("User not found");
//    }
//    if(userRepository.existsByUsername(command.getUsername())){
//      throw new UserAlreadyExistsException("Username already exists");
//    }
//    if(userRepository.existsByEmail(command.getEmail())){
//      throw new UserAlreadyExistsException("Email already exists");
//    }
//
//    User user = new User(command.getId(), command.getUsername(), command.getEmail(),  command.getPassword());
//
//    return userRepository.updateUser(user);
//  }
}
