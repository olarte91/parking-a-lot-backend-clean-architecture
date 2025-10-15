package com.katusoft.api.dto;

import com.katusoft.model.fare.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FareRequest {
  private Type type;
  private double amount;
}
