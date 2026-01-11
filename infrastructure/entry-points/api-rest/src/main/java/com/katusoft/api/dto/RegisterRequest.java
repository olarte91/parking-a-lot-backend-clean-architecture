package com.katusoft.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  @NotBlank(message = "La placa es obligatoria")
  @Pattern(regexp = "^[A-Za-z]{3}[0-9]{2}[0-9A-Za-z]$", message = "Formato de placa inválido (Ej: ABC123 o ABC12A)")
  private String licensePlate;

  @NotNull(message = "El número de espacio es obligatorio")
  private Integer parkingSpaceNumber;

  @NotBlank(message = "El tipo de vehículo es obligatorio")
  private String vehicleType;

}
