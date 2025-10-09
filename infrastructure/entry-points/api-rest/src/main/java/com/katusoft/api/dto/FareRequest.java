package com.katusoft.api.dto;

import com.katusoft.model.fare.FareType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FareRequest {
  private FareType fareType;
  private double amount;
}
