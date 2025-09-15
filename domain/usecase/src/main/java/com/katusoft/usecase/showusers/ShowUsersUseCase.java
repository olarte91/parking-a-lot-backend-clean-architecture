package com.katusoft.usecase.showusers;

import com.katusoft.model.user.User;
import com.katusoft.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ShowUsersUseCase {

  private final UserRepository userRepository;

}
