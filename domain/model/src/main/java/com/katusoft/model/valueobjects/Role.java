package com.katusoft.model.valueobjects;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Role {
  private static final List<String> VALID_ROLES = Arrays.asList(
      "USER", "ADMIN", "MODERATOR"
  );

  private final String value;

  public Role(String value) {
    if(value == null || value.trim().isEmpty()){
      throw new IllegalArgumentException("The role value cannot be null or empty");
    }

    String normalizedRole = value.trim().toUpperCase();

    if(!VALID_ROLES.contains(normalizedRole)){
      throw new IllegalArgumentException("Rol inválido: " + value +
          ". Roles permitidos: " + VALID_ROLES);
    }

    this.value = normalizedRole;
  }

  public String getValue(){
    return value;
  }

  //Métodos de conveniencia
  public boolean isAdmin(){
    return "ADMIN".equals(value);
  }

  public boolean isModerator(){
    return "MODERATOR".equals(value);
  }

  public boolean isUser(){
    return "USER".equals(value);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Role role = (Role) obj;
    return Objects.equals(value, role.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  // Factory methods para crear roles comunes
  public static Role user() {
    return new Role("USER");
  }

  public static Role admin() {
    return new Role("ADMIN");
  }

  public static Role moderator() {
    return new Role("MODERATOR");
  }
}
