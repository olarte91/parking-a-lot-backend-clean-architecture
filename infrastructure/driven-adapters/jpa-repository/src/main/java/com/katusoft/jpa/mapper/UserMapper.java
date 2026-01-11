package com.katusoft.jpa.mapper;

import com.katusoft.jpa.entity.UserEntity;
import com.katusoft.model.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
  public User toDomain(UserEntity entity) {
    if (entity == null) return null;
    return new User(
        entity.getId(),
        entity.getUsername(),
        entity.getEmail(),
        entity.getPassword(),
        entity.getRole()
    );
  }

  public UserEntity toEntity(User domain) {
    if (domain == null) return null;
    return UserEntity.builder()
        .id(domain.getId())
        .username(domain.getUsername())
        .email(domain.getEmail())
        .password(domain.getPassword())
        .role(domain.getRole())
        .build();
  }
}
