package com.katusoft.api.dto;

import com.katusoft.model.vehicle.Vehicle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleResponse {

  private String licensePlate;

  public VehicleResponse (Vehicle vehicle){
    this.licensePlate = vehicle.getLicensePlate();
  }
}
