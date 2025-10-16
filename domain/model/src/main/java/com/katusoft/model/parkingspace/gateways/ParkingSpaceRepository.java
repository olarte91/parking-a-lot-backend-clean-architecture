package com.katusoft.model.parkingspace.gateways;

import com.katusoft.model.fare.Type;
import com.katusoft.model.parkingspace.ParkingSpace;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParkingSpaceRepository {

  ParkingSpace createParkingSpace(ParkingSpace parkingSpace);
  Optional<ParkingSpace> findById(int id);
  List<ParkingSpace> findAll();
  Optional<ParkingSpace> findAvailableByType(Type type);
  List<ParkingSpace> findAllAvailable();
  void deleteById(UUID id);
  long countByType(Type type);
  boolean existsById(UUID id);
  boolean existsByNumber(int number);
  boolean isAvailable (int number);

}
