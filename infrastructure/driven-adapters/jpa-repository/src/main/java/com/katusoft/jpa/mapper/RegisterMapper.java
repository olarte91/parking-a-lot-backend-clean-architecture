package com.katusoft.jpa.mapper;

import com.katusoft.jpa.entity.RegisterEntity;
import com.katusoft.model.register.Register;
import com.katusoft.model.register.VehicleType;
import com.katusoft.model.valueobjects.LicensePlate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterMapper {

  private final UserMapper userMapper;
  private final ParkingSpaceMapper parkingSpaceMapper;

  public RegisterEntity toEntity(Register domain) {
    if (domain == null) return null;

    return RegisterEntity.builder()
        .id(domain.getId())
        .licensePlate(domain.getLicensePlate().toUpperCase())
        .vehicleType(domain.getVehicleType().name())
        .entrance(domain.getEntrance())
        .departure(domain.getDeparture())
        .totalPrice(domain.getTotalPrice())

        .parkingSpace(parkingSpaceMapper.toEntity(domain.getParkingSpace()))
        .user(userMapper.toEntity(domain.getUser()))
        .build();
  }

  public Register toDomain(RegisterEntity entity) {
    if (entity == null) return null;

    return new Register(
        entity.getId(),
        new LicensePlate(entity.getLicensePlate()),
        parkingSpaceMapper.toDomain(entity.getParkingSpace()),
        VehicleType.valueOf(entity.getVehicleType()),
        userMapper.toDomain(entity.getUser()),
        entity.getTotalPrice(),
        entity.getEntrance(),
        entity.getDeparture()
    );
  }
}
