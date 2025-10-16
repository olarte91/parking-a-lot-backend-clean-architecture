package com.katusoft.usecase.getactivevehicles;

import com.katusoft.model.fare.Type;
import com.katusoft.model.parkingspace.Status;
import com.katusoft.model.valueobjects.LicensePlate;
import com.katusoft.model.valueobjects.ParkingSpaceNumber;

import java.time.LocalDateTime;

public class GetActiveVehiclesCommand {

  private LicensePlate licensePlate;
  private LocalDateTime startTime;
  private Status status;
  private Type type;
  private ParkingSpaceNumber parkingSpaceNumber;

  public GetActiveVehiclesCommand(String licensePlate, LocalDateTime startTime,
                                  Status status, Type type, ParkingSpaceNumber parkingSpaceNumber){
    this.licensePlate = new LicensePlate(licensePlate);
    this.startTime = startTime;
    this.status = status;
    this.type = type;
    this.parkingSpaceNumber = parkingSpaceNumber;
  }

  public String getLicensePlate(){
    return this.licensePlate.getValue();
  }

  public LocalDateTime getStartTime(){
    return this.startTime;
  }

  public Status getStatus(){
    return this.status;
  }

  public Type getType(){
    return this.type;
  }

  public ParkingSpaceNumber getParkingSpaceNumber(){
    return this.parkingSpaceNumber;
  }
}
