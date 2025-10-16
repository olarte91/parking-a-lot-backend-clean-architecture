package com.katusoft.api.dto;

import com.katusoft.model.fare.Type;
import com.katusoft.model.parkingspace.ParkingSpace;
import com.katusoft.model.parkingspace.Status;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ParkingSpaceResponse {
  private UUID id;
  private Type type;
  private int number;
  private Status status;

  public ParkingSpaceResponse(ParkingSpace parkingSpace){
    this.id = parkingSpace.getId();
    this.type = parkingSpace.getType();
    this.number = parkingSpace.getParkingSpacenumber();
    this.status = parkingSpace.getStatus();
  }
}
