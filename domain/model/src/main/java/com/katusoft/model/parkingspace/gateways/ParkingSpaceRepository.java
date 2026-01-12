package com.katusoft.model.parkingspace.gateways;

import com.katusoft.model.parkingspace.ParkingSpace;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParkingSpaceRepository {

  //Commands
  ParkingSpace save(ParkingSpace parkingSpace);
  void deleteById(UUID id);

  //Queries
  Optional<ParkingSpace> findById(UUID id);
  Optional<ParkingSpace> findByNumber(Integer number);
  List<ParkingSpace> findAll();

  //Business queries
  List<ParkingSpace> findAllAvailable();
  boolean existsById(UUID id);
  boolean isNumberAvailable(int number);

}
