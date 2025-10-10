package com.katusoft.model.fare;

import com.katusoft.model.valueobjects.ValuePerHour;

import java.util.UUID;

public class Fare {
  private UUID id;
  private FareType fareType;
  private ValuePerHour valuePerHour;

  public Fare(UUID id, FareType fareType, double valuePerHour) {
    this.id = id;
    this.fareType = fareType;
    this.valuePerHour = new ValuePerHour(valuePerHour);
  }

  public UUID getId() {
    return id;
  }

  public FareType getFareType() {
    return fareType;
  }

  public double getValuePerHour() {
    return valuePerHour.getValue();
  }

  public void setValuePerHour(double valuePerHour) {
    this.valuePerHour = new ValuePerHour(valuePerHour);
  }


}
