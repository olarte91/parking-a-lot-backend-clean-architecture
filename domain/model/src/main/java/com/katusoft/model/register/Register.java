package com.katusoft.model.register;

import com.katusoft.model.fare.Fare;
import com.katusoft.model.valueobjects.LicensePlate;

import java.time.LocalDateTime;
import java.util.UUID;

public class Register {

  private final UUID id;
  private LicensePlate licensePlate;
  private UUID spaceId;
  private UUID userId;
  private UUID fareId;
  private double totalPrice;
  private LocalDateTime entrance;
  private LocalDateTime departure;

  public Register(String licensePlate, UUID spaceId, UUID userId, UUID fareId){
    this.id = UUID.randomUUID();
    this.licensePlate = new  LicensePlate(licensePlate);
    this.spaceId = spaceId;
    this.userId = userId;
    this.fareId = fareId;
  }
}
