package com.katusoft.jpa;

import com.katusoft.jpa.entity.UserEntity;
import com.katusoft.jpa.helper.AdapterOperations;
import com.katusoft.jpa.mapper.UserMapper;
import com.katusoft.model.user.User;
import com.katusoft.model.user.gateways.UserRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaUserRepositoryAdapter extends AdapterOperations<User, UserEntity, UUID, JpaUserRepository>
    implements UserRepository {

  private final UserMapper userMapper;

  public JpaUserRepositoryAdapter(JpaUserRepository repository, ObjectMapper mapper, UserMapper userMapper) {
    /**
     *  Could be use mapper.mapBuilder if your domain model implement builder pattern
     *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
     *  Or using mapper.map with the class of the object model
     */
    super(repository, mapper, d -> mapper.map(d, User.class));
    this.userMapper = userMapper;
  }

  @Override
  public boolean findByEmail(String email) {
    return repository.findByEmail(email).isPresent();
  }

  @Override
  public boolean findByUsername(String username) {
    return repository.findByUsername(username).isPresent();
  }

  @Override
  public Optional<User> findUserByUsername(String username) {
    return repository.findByUsername(username)
        .map(userMapper::toDomain);
  }

  @Override
  public Optional<User> findUserById(UUID id) {
    return repository.findById(id).map(userMapper::toDomain);
  }

  @Override
  public User createUser(User user) {
    return save(user);
  }

  @Override
  public User updateUser(User user) {
    return save(user);
  }

  @Override
  public void deleteUser(UUID userId) {
    repository.deleteById(userId);
  }

  @Override
  protected UserEntity toData(User user) {
    return userMapper.toEntity(user);
  }
}
