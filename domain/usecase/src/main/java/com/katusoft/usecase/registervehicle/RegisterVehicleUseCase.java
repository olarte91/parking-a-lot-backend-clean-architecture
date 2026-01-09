package com.katusoft.usecase.registervehicle;

import com.katusoft.model.exception.FareNotFoundException;
import com.katusoft.model.exception.ParkingSpaceAlreadyOccupiedException;
import com.katusoft.model.exception.VehicleAlreadyExistsException;
import com.katusoft.model.fare.gateways.FareRepository;
import com.katusoft.model.parkingspace.gateways.ParkingSpaceRepository;
import com.katusoft.model.vehicle.Vehicle;
import com.katusoft.model.vehicle.gateways.VehicleRepository;

import java.util.UUID;

public class RegisterVehicleUseCase {

  private final VehicleRepository vehicleRepository;
  private final ParkingSpaceRepository parkingSpaceRepository;


  public RegisterVehicleUseCase(VehicleRepository vehicleRepository,
                                ParkingSpaceRepository parkingSpaceRepository) {
    this.vehicleRepository = vehicleRepository;
    this.parkingSpaceRepository = parkingSpaceRepository;
  }

  public Vehicle execute(String licensePlate, Integer parkingSpaceNumber) {

    if (!parkingSpaceRepository.isAvailable(parkingSpaceNumber)) {
      throw new ParkingSpaceAlreadyOccupiedException("ParkingSpace already occupied");
    }

    return null;
  }
}
