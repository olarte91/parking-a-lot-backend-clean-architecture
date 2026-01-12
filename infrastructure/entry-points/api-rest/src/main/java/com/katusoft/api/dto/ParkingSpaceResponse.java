package com.katusoft.api.dto;

import com.katusoft.model.parkingspace.ParkingSpace;
import com.katusoft.model.parkingspace.Status;
import com.katusoft.model.register.VehicleType;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ParkingSpaceResponse {
  private UUID id;
  private VehicleType type;
  private int number;
  private Status status;

  public ParkingSpaceResponse(ParkingSpace parkingSpace){
    this.id = parkingSpace.getId();
    this.type = parkingSpace.getType();
    this.number = parkingSpace.getParkingSpacenumber();
    this.status = parkingSpace.getStatus();
  }
}
