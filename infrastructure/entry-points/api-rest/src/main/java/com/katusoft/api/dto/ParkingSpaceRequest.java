package com.katusoft.api.dto;

import com.katusoft.model.fare.Type;
import com.katusoft.model.parkingspace.Status;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParkingSpaceRequest {

  @NotBlank
  private Type type;

  @Min(0)
  @Max(100)
  private int number;

}
