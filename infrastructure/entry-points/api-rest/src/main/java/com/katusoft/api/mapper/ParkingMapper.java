package com.katusoft.api.mapper;

import com.katusoft.api.dto.ParkingSpaceResponse;
import com.katusoft.model.parkingspace.ParkingSpace;

import java.util.List;

public interface ParkingMapper {
  ParkingSpaceResponse toResponse(ParkingSpace domain);
  List<ParkingSpaceResponse> toResponseList(List<ParkingSpace> domainList);
}
