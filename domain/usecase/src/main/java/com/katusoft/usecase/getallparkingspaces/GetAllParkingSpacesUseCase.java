package com.katusoft.usecase.getallparkingspaces;

import com.katusoft.model.parkingspace.ParkingSpace;
import com.katusoft.model.parkingspace.gateways.ParkingSpaceRepository;

import java.util.List;

public class GetAllParkingSpacesUseCase {

  ParkingSpaceRepository parkingSpaceRepository;

  public GetAllParkingSpacesUseCase(ParkingSpaceRepository parkingSpaceRepository){
    this.parkingSpaceRepository = parkingSpaceRepository;
  }

  public List<ParkingSpace> execute(){
    return parkingSpaceRepository.findAll();
  }
}
