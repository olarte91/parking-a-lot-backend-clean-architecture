package com.katusoft.api.controller;

import com.katusoft.api.dto.VehicleRequest;
import com.katusoft.api.dto.VehicleResponse;
import com.katusoft.model.vehicle.Vehicle;
import com.katusoft.usecase.registervehicle.RegisterVehicleUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

  private final RegisterVehicleUseCase registerVehicleUseCase;

  public VehicleController(RegisterVehicleUseCase registerVehicleUseCase) {
    this.registerVehicleUseCase = registerVehicleUseCase;
  }

  @PostMapping("/register")
  public ResponseEntity<VehicleResponse> registerVehicle(@RequestBody VehicleRequest vehicleRequest) {
    Vehicle vehicle = registerVehicleUseCase.execute(vehicleRequest.getLicensePlate(), vehicleRequest.getFareId());

    return ResponseEntity.ok(new VehicleResponse(vehicle));

  }


}
