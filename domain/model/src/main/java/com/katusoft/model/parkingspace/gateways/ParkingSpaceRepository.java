package com.katusoft.model.parkingspace.gateways;

import com.katusoft.model.parkingspace.ParkingSpace;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParkingSpaceRepository {

  //Commands
  ParkingSpace save(ParkingSpace parkingSpace);

  //Queries
  Optional<ParkingSpace> findByNumber(Integer number);
  List<ParkingSpace> findAll();

  //Business queries
  boolean isNumberAvailable(int number);

}
