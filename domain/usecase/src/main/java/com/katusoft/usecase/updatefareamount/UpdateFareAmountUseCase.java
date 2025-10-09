package com.katusoft.usecase.updatefareamount;

import com.katusoft.model.exception.FareNotFoundException;
import com.katusoft.model.fare.Fare;
import com.katusoft.model.fare.gateways.FareRepository;

public class UpdateFareAmountUseCase {

  private final FareRepository fareRepository;

  public UpdateFareAmountUseCase(FareRepository fareRepository) {
    this.fareRepository = fareRepository;
  }

  public Fare execute(UpdateFareAmountCommand updateFareAmountCommand) {
    Fare fare = fareRepository.findById(updateFareAmountCommand.getFareId())
        .orElseThrow(() -> new FareNotFoundException("Tarifa no encontrada " +  updateFareAmountCommand.getFareId()));

    fare.setValuePerHour(updateFareAmountCommand.getAmount());

    return fareRepository.createFare(fare);
  }
}
