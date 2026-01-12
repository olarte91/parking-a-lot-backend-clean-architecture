  package com.katusoft.model.fare;

  import com.katusoft.model.valueobjects.ValuePerHour;

  import java.util.UUID;

  public class Fare {
    private final UUID id;
    private String vehicleType;
    private ValuePerHour valuePerHour;

    public Fare(UUID id, String vehicleType, double valuePerHour) {
      this.id = id;
      this.vehicleType = vehicleType;
      this.valuePerHour = new ValuePerHour(valuePerHour);
    }

    public UUID getId() {
      return id;
    }

    public String getFareType() {
      return vehicleType;
    }

    public double getValuePerHour() {
      return valuePerHour.getValue();
    }

    public void setValuePerHour(double valuePerHour) {
      this.valuePerHour = new ValuePerHour(valuePerHour);
    }


  }
