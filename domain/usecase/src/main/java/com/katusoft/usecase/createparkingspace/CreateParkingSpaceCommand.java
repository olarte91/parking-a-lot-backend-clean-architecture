package com.katusoft.usecase.createparkingspace;

import com.katusoft.model.fare.Type;

public class CreateParkingSpaceCommand {

  private Type type;
  private int number;

  public CreateParkingSpaceCommand(Type type, int number) {
    this.type = type;
    this.number = number;
  }

  public Type getType() {
    return type;
  }

  public int getNumber() {
    return number;
  }
}
