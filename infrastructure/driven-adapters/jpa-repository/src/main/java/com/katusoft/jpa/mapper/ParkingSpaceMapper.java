package com.katusoft.jpa.mapper;

import com.katusoft.jpa.entity.ParkingSpaceEntity;
import com.katusoft.model.parkingspace.ParkingSpace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParkingSpaceMapper {

  public ParkingSpaceEntity toEntity(ParkingSpace parkingSpace) {
    return ParkingSpaceEntity.builder()
        .id(parkingSpace.getId())
        .status(parkingSpace.getStatus())
        .number(parkingSpace.getParkingSpacenumber())
        .type(parkingSpace.getType())
        .build();
  }

  public ParkingSpace toDomain(ParkingSpaceEntity parkingSpaceEntity) {
    return new ParkingSpace(
        parkingSpaceEntity.getId(),
        parkingSpaceEntity.getType(),
        parkingSpaceEntity.getNumber(),
        parkingSpaceEntity.getStatus()
    );
  }
}
