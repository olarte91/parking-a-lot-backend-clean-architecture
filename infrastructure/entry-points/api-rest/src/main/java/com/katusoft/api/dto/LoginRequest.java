package com.katusoft.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginRequest {

  @NotBlank(message = "Username requerido")
   private String username;

  @NotBlank(message = "Contraseña requerida")
  @Size(min = 6, message = "La contraseña debe tener almenos 6 caracteres")
   private String password;

}
