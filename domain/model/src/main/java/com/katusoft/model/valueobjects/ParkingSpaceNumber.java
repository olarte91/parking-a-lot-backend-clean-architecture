package com.katusoft.model.valueobjects;

import com.katusoft.model.exception.InvalidParkingSpaceNumberException;

import java.util.Objects;

public class ParkingSpaceNumber {

  private final int value;

  public ParkingSpaceNumber(int value){
    if(value < 0){
      throw new InvalidParkingSpaceNumberException("Parking space number must be a positive integer");
    }
    if(value > 100){
      throw new InvalidParkingSpaceNumberException("Parking space number must be less than 100");
    }
    this.value = value;
  }

  public int getValue(){
    return value;
  }

  @Override
  public boolean equals(Object o){
    if(this == o) return true;
    if(o == null || getClass() != o.getClass()) return false;
    ParkingSpaceNumber that = (ParkingSpaceNumber) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode(){
    return Objects.hash(value);
  }
}
