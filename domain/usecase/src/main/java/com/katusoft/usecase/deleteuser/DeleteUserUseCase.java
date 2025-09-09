package com.katusoft.usecase.deleteuser;

import com.katusoft.model.exception.UserNotFoundException;
import com.katusoft.model.user.gateways.UserRepository;

import java.util.UUID;

public class DeleteUserUseCase {

  private final UserRepository userRepository;

  public DeleteUserUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void execute(UUID id){
    if(userRepository.findUserById(id)){
      throw new UserNotFoundException("User not found");
    }
    userRepository.deleteUser(id);
  }
}
