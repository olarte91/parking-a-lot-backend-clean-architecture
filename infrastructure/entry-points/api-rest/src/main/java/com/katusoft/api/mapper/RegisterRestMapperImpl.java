package com.katusoft.api.mapper;

import com.katusoft.api.dto.ExitResponse;
import com.katusoft.api.dto.RegisterResponse;
import com.katusoft.model.register.Register;
import org.springframework.stereotype.Component;

@Component
public class RegisterRestMapperImpl implements RegisterRestMapper {

  @Override
  public RegisterResponse toResponse(Register domain) {
    return new RegisterResponse(
      domain.getLicensePlate(),
        domain.getVehicleType().toString(),
        domain.getEntrance().toString(),
        domain.getParkingSpace().getParkingSpacenumber()

    );
  }

  @Override
  public ExitResponse toExitResponse(Register register) {
    if (register == null) return null;

    long hours = java.time.Duration.between(
        register.getEntrance(),
        register.getDeparture()
    ).toHours();
    if (hours == 0) hours = 1;

    return ExitResponse.builder()
        .licensePlate(register.getLicensePlate())
        .entryDate(register.getEntrance())
        .exitDate(register.getDeparture())
        .hours(hours)
        .totalPrice(register.getTotalPrice())
        .build();
  }
}
