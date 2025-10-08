package com.katusoft.model.valueobjects;

import com.katusoft.model.exception.InvalidValuePerHourException;

import java.util.Objects;

public class ValuePerHour {

  private double value;

  public ValuePerHour() {}

  public ValuePerHour(double value) {
    if(value < 0) {
      throw new InvalidValuePerHourException("The value must be greater than 0");
    }
    this.value = value;
  }

  public double getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(o == null || getClass() != o.getClass()) return false;
    ValuePerHour value =  (ValuePerHour) o;
    return Objects.equals(value, value.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
