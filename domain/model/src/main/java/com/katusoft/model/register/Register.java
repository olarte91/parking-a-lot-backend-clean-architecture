package com.katusoft.model.register;

import com.katusoft.model.parkingspace.ParkingSpace;
import com.katusoft.model.user.User;
import com.katusoft.model.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public class Register {

  private final UUID id;
  private Vehicle vehicle;
  private ParkingSpace parkingSpace;
  private User user;
  private double totalPrice;
  private LocalDateTime entrance;
  private LocalDateTime departure;

  public Register(Vehicle vehicle, ParkingSpace parkingSpace, User user){
    this.id = UUID.randomUUID();
    this.vehicle = vehicle;
    this.parkingSpace = parkingSpace;
    this.user = user;
  }

}
