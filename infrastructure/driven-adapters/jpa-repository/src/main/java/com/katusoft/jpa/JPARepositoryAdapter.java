package com.katusoft.jpa;

import com.katusoft.jpa.entity.UserEntity;
import com.katusoft.jpa.helper.AdapterOperations;
import com.katusoft.model.user.User;
import com.katusoft.model.user.gateways.UserRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<User, UserEntity, UUID, JPARepository>
    implements UserRepository {

  public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
    /**
     *  Could be use mapper.mapBuilder if your domain model implement builder pattern
     *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
     *  Or using mapper.map with the class of the object model
     */
    super(repository, mapper, d -> mapper.map(d, User.class));
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
        .map(entity -> mapper.map(entity, User.class));
  }

  @Override
  public boolean findUserById(UUID id) {
    return repository.findById(id).isPresent();
  }

  @Override
  public User createUser(User user) {
    UserEntity entity = new UserEntity(
        user.getId(),
        user.getUsername(),
        user.getEmail(),
        user.getPassword(),
        user.getRole()
    );
    UserEntity saved = repository.save(entity);

    return new User(
        saved.getId(),
        saved.getUsername(),
        saved.getEmail(),
        saved.getPassword()
        );
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
    return new UserEntity(
        user.getId(),
        user.getUsername(),
        user.getEmail(),
        user.getPassword(),
        user.getRole()
    );
  }
}
