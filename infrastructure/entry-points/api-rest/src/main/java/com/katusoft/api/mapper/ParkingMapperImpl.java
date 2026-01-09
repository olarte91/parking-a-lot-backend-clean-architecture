package com.katusoft.api.mapper;

import com.katusoft.api.dto.ParkingSpaceResponse;
import com.katusoft.model.parkingspace.ParkingSpace;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ParkingMapperImpl implements ParkingMapper {
  @Override
  public ParkingSpaceResponse toResponse(ParkingSpace domain) {
    if(domain ==  null) return null;

    return new ParkingSpaceResponse(domain);
  }

  @Override
  public List<ParkingSpaceResponse> toResponseList(List<ParkingSpace> domainList) {
    if(domainList == null) return Collections.emptyList();

    return domainList.stream()
        .map(this::toResponse)
        .toList();
  }
}
