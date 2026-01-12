package com.katusoft.usecase.createparkingspace;

import com.katusoft.model.register.VehicleType;

public class CreateParkingSpaceCommand {

  private VehicleType type;
  private int number;

  public CreateParkingSpaceCommand(VehicleType type, int number) {
    this.type = type;
    this.number = number;
  }

  public VehicleType getType() {
    return type;
  }

  public int getNumber() {
    return number;
  }
}
