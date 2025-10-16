package com.katusoft.model.fare;

import com.katusoft.model.valueobjects.ValuePerHour;

import java.util.UUID;

public class Fare {
  private final UUID id;
  private Type type;
  private ValuePerHour valuePerHour;

  public Fare(UUID id, Type type, double valuePerHour) {
    this.id = id;
    this.type = type;
    this.valuePerHour = new ValuePerHour(valuePerHour);
  }

  public UUID getId() {
    return id;
  }

  public Type getFareType() {
    return type;
  }

  public double getValuePerHour() {
    return valuePerHour.getValue();
  }

  public void setValuePerHour(double valuePerHour) {
    this.valuePerHour = new ValuePerHour(valuePerHour);
  }


}
