package com.katusoft.model.vehicle;

import com.katusoft.model.valueobjects.LicensePlate;

import java.util.UUID;

public class Vehicle {

  private LicensePlate licensePlate;
  private UUID fareId;

  public Vehicle(LicensePlate licensePlate, UUID fareId) {
    this.licensePlate = licensePlate;
    this.fareId = fareId;
  }

  public String getLicensePlate() {
    return licensePlate.getValue();
  }

  public UUID getFareId() {
    return fareId;
  }

  private static Vehicle create(String licensePlate, UUID fareId){
    validateInputs(licensePlate, fareId);
    return new Vehicle(new LicensePlate(licensePlate), fareId);
  }

  private static void validateInputs(String licensePlate, UUID fareId){
    if(licensePlate == null || licensePlate.isBlank()){
      throw new IllegalArgumentException("License plate cannot be null or blank");
    }
    if(fareId == null){
      throw new IllegalArgumentException("Fare ID cannot be null");
    }
  }

}
