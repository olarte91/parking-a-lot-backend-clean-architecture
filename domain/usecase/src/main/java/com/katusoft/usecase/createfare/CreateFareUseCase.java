package com.katusoft.usecase.createfare;

import com.katusoft.model.exception.FareAlreadyExistsException;
import com.katusoft.model.fare.Fare;
import com.katusoft.model.fare.gateways.FareRepository;

import java.util.UUID;

public class CreateFareUseCase {

  private final FareRepository fareRepository;

  public CreateFareUseCase(FareRepository fareRepository){
    this.fareRepository = fareRepository;
  }

  public Fare execute(CreateFareCommand command){
    if(fareRepository.existsByType(command.getFareType())){
      throw new FareAlreadyExistsException("Ya existe una tarifa para el tipo " + command.getFareType());
    }

    Fare newFare = new Fare(
        UUID.randomUUID(),
        command.getFareType(),
        command.getAmount()
    );

    return fareRepository.createFare(newFare);
  }
}
