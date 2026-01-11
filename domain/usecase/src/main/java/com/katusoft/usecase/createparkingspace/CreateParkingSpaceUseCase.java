package com.katusoft.usecase.createparkingspace;

import com.katusoft.model.exception.ParkingSpaceAlreadyExistsException;
import com.katusoft.model.parkingspace.ParkingSpace;
import com.katusoft.model.parkingspace.gateways.ParkingSpaceRepository;

public class CreateParkingSpaceUseCase {

  ParkingSpaceRepository parkingSpaceRepository;

  public CreateParkingSpaceUseCase(ParkingSpaceRepository parkingSpaceRepository) {
    this.parkingSpaceRepository = parkingSpaceRepository;
  }

  public ParkingSpace execute(CreateParkingSpaceCommand createParkingSpaceCommand) {
    if(parkingSpaceRepository.isNumberAvailable(createParkingSpaceCommand.getNumber())) {
      throw new ParkingSpaceAlreadyExistsException("Parking space already exists with number " +
          createParkingSpaceCommand.getNumber());
    }
    ParkingSpace parkingSpace = new ParkingSpace(createParkingSpaceCommand.getType(), createParkingSpaceCommand.getNumber());
    return parkingSpaceRepository.save(parkingSpace);
  }
}
