package com.katusoft.api.mapper;

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
}
