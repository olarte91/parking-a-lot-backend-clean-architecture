package com.katusoft.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExitResponse {

  private String licensePlate;
  private LocalDateTime entryDate;
  private LocalDateTime exitDate;
  public Long hours;
  public Double totalPrice;
}
