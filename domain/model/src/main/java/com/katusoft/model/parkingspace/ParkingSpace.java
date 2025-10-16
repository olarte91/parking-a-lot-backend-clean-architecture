package com.katusoft.model.parkingspace;

import com.katusoft.model.exception.ParkingSpaceAlreadyAvailableException;
import com.katusoft.model.exception.ParkingSpaceAlreadyOccupiedException;
import com.katusoft.model.fare.Type;
import com.katusoft.model.valueobjects.ParkingSpaceNumber;

import java.util.Objects;
import java.util.UUID;

public class ParkingSpace {

  private final UUID id;
  private Type type;
  private ParkingSpaceNumber number;
  private Status status;

  public ParkingSpace(Type type, int number) {
    this.id = UUID.randomUUID();
    this.type = Objects.requireNonNull(type, "Type cannot be null");
    this.number = new ParkingSpaceNumber(number);
    this.status = Status.AVAILABLE;
  }

  public UUID getId() {
    return id;
  }

  public Type getType() {
    return type;
  }

  public int getParkingSpacenumber(){
    return this.number.getValue();
  }

  public Status getStatus() {
    return status;
  }

  public void occupy(){
    if(this.status == Status.OCCUPIED){
      throw new ParkingSpaceAlreadyOccupiedException("ParkingSpace already occupied");
    }
    this.status = Status.OCCUPIED;
  }

  public void free(){
    if(this.status == Status.AVAILABLE){
      throw new ParkingSpaceAlreadyAvailableException("ParkingSpace already available");
    }
    this.status = Status.AVAILABLE;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(o == null || getClass() != o.getClass()) return false;
    ParkingSpace that = (ParkingSpace) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
