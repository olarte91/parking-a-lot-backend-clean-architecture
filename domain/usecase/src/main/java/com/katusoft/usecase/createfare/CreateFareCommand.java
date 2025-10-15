package com.katusoft.usecase.createfare;

import com.katusoft.model.fare.Type;

public class CreateFareCommand {

  private Type type;
  private double amount;

  public CreateFareCommand(Type type, double amount) {
    this.type = type;
    this.amount = amount;
  }

  public Type getFareType() {
    return type;
  }

  public double getAmount() {
    return amount;
  }
}
