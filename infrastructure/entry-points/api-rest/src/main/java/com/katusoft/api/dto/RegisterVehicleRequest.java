package com.katusoft.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterVehicleRequest {

  public String licensePlate;
  public Integer parkingSpace;
}
