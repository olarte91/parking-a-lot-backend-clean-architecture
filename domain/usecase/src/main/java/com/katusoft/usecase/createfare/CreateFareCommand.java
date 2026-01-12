package com.katusoft.usecase.createfare;

public class CreateFareCommand {

  private String type;
  private double amount;

  public CreateFareCommand(String type, double amount) {
    this.type = type;
    this.amount = amount;
  }

  public String getFareType() {
    return type;
  }

  public double getAmount() {
    return amount;
  }
}
