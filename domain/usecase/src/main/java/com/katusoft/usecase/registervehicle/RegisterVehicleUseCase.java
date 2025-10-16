package com.katusoft.usecase.registervehicle;

import com.katusoft.model.exception.FareNotFoundException;
import com.katusoft.model.exception.VehicleAlreadyExistsException;
import com.katusoft.model.fare.gateways.FareRepository;
import com.katusoft.model.parkingspace.gateways.ParkingSpaceRepository;
import com.katusoft.model.vehicle.Vehicle;
import com.katusoft.model.vehicle.gateways.VehicleRepository;

import java.util.UUID;

public class RegisterVehicleUseCase {

  private final VehicleRepository vehicleRepository;
  private final FareRepository fareRepository;
  private final ParkingSpaceRepository parkingSpaceRepository;


  public RegisterVehicleUseCase(VehicleRepository vehicleRepository,  FareRepository fareRepository,
                                ParkingSpaceRepository parkingSpaceRepository) {
    this.vehicleRepository = vehicleRepository;
    this.fareRepository = fareRepository;
    this.parkingSpaceRepository = parkingSpaceRepository;
  }

  public Vehicle execute(String licensePlate, UUID fareId){

    //Validación de regla de negocio
    if(vehicleRepository.existsByLicensePlate(licensePlate)){
      throw new VehicleAlreadyExistsException("Vehicle with license plate " + licensePlate + " already exists");
    }

    //Validación de existencia de tarifa
    if(!fareRepository.existsById(fareId)){
      throw new FareNotFoundException("Fare with id " + fareId + " not found");
    }

    //Crear y guardar el vehículo
    Vehicle vehicle = Vehicle.create(licensePlate, fareId);
    return vehicleRepository.saveVehicle(vehicle);
  }
}
