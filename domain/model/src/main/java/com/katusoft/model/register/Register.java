package com.katusoft.model.register;

import com.katusoft.model.parkingspace.ParkingSpace;
import com.katusoft.model.user.User;
import com.katusoft.model.valueobjects.LicensePlate;

import java.time.LocalDateTime;
import java.util.UUID;

public class Register {

  private final UUID id;
  private LicensePlate licensePlate;
  private ParkingSpace parkingSpace;
  private VehicleType vehicleType;
  private User user;
  private double totalPrice;
  private LocalDateTime entrance;
  private LocalDateTime departure;

public Register(String licensePlate, ParkingSpace parkingSpace, VehicleType vehicleType, User user){
  this.id = UUID.randomUUID();
  this.licensePlate = new LicensePlate(licensePlate);
  this.parkingSpace = parkingSpace;
  this.vehicleType = vehicleType;
  this.user = user;
  this.entrance = LocalDateTime.now();
}

public Register (UUID id, LicensePlate licensePlate, ParkingSpace parkingSpace, VehicleType vehicleType, User user,
                 double totalPrice, LocalDateTime entrance, LocalDateTime departure){
  this.id = id;
  this.licensePlate = licensePlate;
  this.parkingSpace = parkingSpace;
  this.vehicleType = vehicleType;
  this.user = user;
  this.totalPrice = totalPrice;
  this.entrance = entrance;
  this.departure = departure;
}

  public void registerDeparture(double price){
    this.departure = LocalDateTime.now();
    this.totalPrice = price;

    if(this.parkingSpace != null){
      this.parkingSpace.free();
    }
  }

  public void setDeparture(LocalDateTime departure){
  this.departure = departure;
  }

  public void setTotalPrice(double totalPrice){
  this.totalPrice = totalPrice;
  }

  public UUID getId() {
  return id;
  }

  public String getLicensePlate() {
  return licensePlate.getValue();
  }

  public VehicleType getVehicleType() {
  return vehicleType;
  }

  public User getUser() {
  return user;
  }

  public double getTotalPrice() {
  return totalPrice;
  }

  public LocalDateTime getEntrance() {
  return entrance;
  }

  public LocalDateTime getDeparture() {
  return departure;
  }

  public ParkingSpace getParkingSpace() {
  return parkingSpace;
  }


}
