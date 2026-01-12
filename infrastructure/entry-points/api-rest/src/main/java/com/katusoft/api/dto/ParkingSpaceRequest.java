package com.katusoft.api.dto;

import com.katusoft.model.register.VehicleType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParkingSpaceRequest {

  @NotNull(message = "El tipo no puede estar en blanco debe ser CARRO o MOTO")
  private VehicleType type;

  @Min(value = 0, message = "El número debe ser mayor a 0")
  @Max(value = 100, message = "El número debe ser menor de 100")
  private int number;

}
