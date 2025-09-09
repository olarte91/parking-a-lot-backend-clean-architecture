package com.katusoft.jpa;

import com.katusoft.jpa.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;
import java.util.UUID;

public interface JPARepository extends CrudRepository<UserEntity, UUID>, QueryByExampleExecutor<UserEntity> {
  Optional<UserEntity> findByEmail(String email);
  Optional<UserEntity> findByUsername(String username);
}
