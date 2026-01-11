package com.katusoft.usecase.registervehicle;

import java.util.UUID;

public class RegisterVehicleCommand {

  private String licensePlate;
  private Integer parkingSpaceNumber;
  private String vehicleType;
  private UUID userId;

  public RegisterVehicleCommand(String licensePlate, Integer parkingSpaceNumber, String vehicleType, UUID userId) {
    this.licensePlate = licensePlate.toUpperCase();
    this.parkingSpaceNumber = parkingSpaceNumber;
    this.vehicleType = vehicleType;
    this.userId = userId;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public Integer  getParkingSpaceNumber() {
    return parkingSpaceNumber;
  }

  public String getVehicleType() {
    return vehicleType;
  }

  public UUID getUserId() {
    return userId;
  }
}
