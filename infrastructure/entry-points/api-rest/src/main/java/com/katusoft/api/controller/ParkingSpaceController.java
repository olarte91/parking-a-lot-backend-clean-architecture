package com.katusoft.api.controller;

import com.katusoft.api.dto.ParkingSpaceRequest;
import com.katusoft.api.dto.ParkingSpaceResponse;
import com.katusoft.model.parkingspace.ParkingSpace;
import com.katusoft.usecase.createparkingspace.CreateParkingSpaceCommand;
import com.katusoft.usecase.createparkingspace.CreateParkingSpaceUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parking-space")
public class ParkingSpaceController {

  private final CreateParkingSpaceUseCase createParkingSpaceUseCase;

  public ParkingSpaceController(CreateParkingSpaceUseCase createParkingSpaceUseCase) {
    this.createParkingSpaceUseCase = createParkingSpaceUseCase;
  }

  @PostMapping("/create")
  public ResponseEntity<ParkingSpaceResponse> create(@RequestBody ParkingSpaceRequest parkingSpaceRequest) {
    CreateParkingSpaceCommand command = new CreateParkingSpaceCommand(
        parkingSpaceRequest.getType(),
        parkingSpaceRequest.getNumber()
    );
    ParkingSpace parkingSpace = createParkingSpaceUseCase.execute(command);

    return ResponseEntity.ok(new ParkingSpaceResponse(parkingSpace));
  }
}
