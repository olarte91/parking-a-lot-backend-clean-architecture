package com.katusoft.api.controller;

import com.katusoft.api.auth.UserPrincipal;
import com.katusoft.api.dto.ExitResponse;
import com.katusoft.api.dto.RegisterRequest;
import com.katusoft.api.dto.RegisterResponse;
import com.katusoft.api.mapper.RegisterRestMapper;
import com.katusoft.model.register.Register;
import com.katusoft.usecase.processvehicleexit.ProcessVehicleExitUseCase;
import com.katusoft.usecase.registervehicle.RegisterVehicleCommand;
import com.katusoft.usecase.registervehicle.RegisterVehicleUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/registers")
public class RegisterController {

  private final RegisterVehicleUseCase registerVehicleUseCase;
  private final ProcessVehicleExitUseCase exitUseCase;
  private final RegisterRestMapper mapper;

  public RegisterController(RegisterVehicleUseCase registerVehicleUseCase,
                            ProcessVehicleExitUseCase exitUseCase,
                            RegisterRestMapper mapper) {
    this.registerVehicleUseCase = registerVehicleUseCase;
    this.exitUseCase = exitUseCase;
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

  @PatchMapping("/exit/{licensePlate}")
  public ResponseEntity<ExitResponse> processExit(@PathVariable("licensePlate") String licensePlate) {

    Register result = exitUseCase.execute(licensePlate);

    ExitResponse response = mapper.toExitResponse(result);

    return ResponseEntity.ok(response);
  }
}
