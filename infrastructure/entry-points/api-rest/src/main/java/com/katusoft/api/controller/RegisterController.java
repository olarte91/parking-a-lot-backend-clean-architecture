package com.katusoft.api.controller;

import com.katusoft.api.auth.UserPrincipal;
import com.katusoft.api.dto.RegisterRequest;
import com.katusoft.api.dto.RegisterResponse;
import com.katusoft.api.mapper.RegisterRestMapper;
import com.katusoft.api.mapper.RegisterRestMapperImpl;
import com.katusoft.model.register.Register;
import com.katusoft.usecase.registervehicle.RegisterVehicleCommand;
import com.katusoft.usecase.registervehicle.RegisterVehicleUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/registers")
public class RegisterController {

  private final RegisterVehicleUseCase registerVehicleUseCase;
  private final RegisterRestMapper mapper;

  public RegisterController(RegisterVehicleUseCase registerVehicleUseCase,
                            RegisterRestMapper mapper) {
    this.registerVehicleUseCase = registerVehicleUseCase;
    this.mapper = mapper;
  }

  @PostMapping
  public ResponseEntity<RegisterResponse> registerVehicle(@Valid @RequestBody RegisterRequest request,
                                                          @AuthenticationPrincipal UserPrincipal user) {
    RegisterVehicleCommand command = new RegisterVehicleCommand(
        request.getLicensePlate(),
        request.getParkingSpaceNumber(),
        request.getVehicleType(),
         user.getId()    );

    Register result = registerVehicleUseCase.execute(command);
    return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(result));
  }
}
