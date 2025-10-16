package com.katusoft.usecase.registervehicle;

import com.katusoft.model.parkingspace.ParkingSpace;
import com.katusoft.model.vehicle.Vehicle;

import java.time.LocalDateTime;

public class RegisterVehicleCommand {

  private Vehicle vehicle;
  private LocalDateTime startTime;
  private ParkingSpace parkingSpace;

  public RegisterVehicleCommand(Vehicle vehicle, LocalDateTime startTime, ParkingSpace parkingSpace) {
    this.vehicle = vehicle;
    this.startTime = startTime;
    this.parkingSpace = parkingSpace;
  }
}
