package com.katusoft.api.dto;

import com.katusoft.model.fare.Fare;
import com.katusoft.model.register.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FareResponse {

  public VehicleType type;
  public double fareAmount;

  public FareResponse(Fare fare) {
    this.type = VehicleType.valueOf(fare.getFareType());
    this.fareAmount = fare.getValuePerHour();
  }
}
