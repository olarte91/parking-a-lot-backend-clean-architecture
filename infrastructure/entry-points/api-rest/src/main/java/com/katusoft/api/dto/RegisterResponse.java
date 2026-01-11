package com.katusoft.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {

  public String licensePlate;
  public String vehicleType;
  public String registrationDate;
  public Integer parkingSpaceNumber;
}
