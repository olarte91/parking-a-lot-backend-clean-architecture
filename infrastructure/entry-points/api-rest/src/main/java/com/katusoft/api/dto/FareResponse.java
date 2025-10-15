package com.katusoft.api.dto;

import com.katusoft.model.fare.Fare;
import com.katusoft.model.fare.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FareResponse {

  public Type type;
  public double fareAmount;

  public FareResponse(Fare fare) {
    this.type = fare.getFareType();
    this.fareAmount = fare.getValuePerHour();
  }
}
