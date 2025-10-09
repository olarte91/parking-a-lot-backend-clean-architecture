package com.katusoft.api.dto;

import com.katusoft.model.fare.Fare;
import com.katusoft.model.fare.FareType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FareResponse {

  public FareType fareType;
  public double fareAmount;

  public FareResponse(Fare fare) {
    this.fareType = fare.getFareType();
    this.fareAmount = fare.getValuePerHour();
  }
}
