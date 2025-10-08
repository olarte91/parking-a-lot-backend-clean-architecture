package com.katusoft.usecase.updatefareamount;

import java.util.UUID;

public class UpdateFareAmountCommand {

  private UUID fareId;
  private double amount;

  public UpdateFareAmountCommand(double amount){
    this.amount = amount;
  }

  public double getAmount() {
    return amount;
  }

  public UUID getFareId() {
    return fareId;
  }
}
