package com.katusoft.usecase.createfare;

import com.katusoft.model.fare.FareType;

public class CreateFareCommand {

  private FareType fareType;
  private double amount;

  public CreateFareCommand(FareType fareType, double amount) {
    this.fareType = fareType;
    this.amount = amount;
  }

  public FareType getFareType() {
    return fareType;
  }

  public double getAmount() {
    return amount;
  }
}
