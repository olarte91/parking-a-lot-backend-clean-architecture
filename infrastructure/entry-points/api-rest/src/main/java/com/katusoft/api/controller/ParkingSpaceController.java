package com.katusoft.api.controller;

import com.katusoft.api.dto.ParkingSpaceRequest;
import com.katusoft.api.dto.ParkingSpaceResponse;
import com.katusoft.api.mapper.ParkingMapper;
import com.katusoft.model.parkingspace.ParkingSpace;
import com.katusoft.usecase.createparkingspace.CreateParkingSpaceCommand;
import com.katusoft.usecase.createparkingspace.CreateParkingSpaceUseCase;
import com.katusoft.usecase.getallparkingspaces.GetAllParkingSpacesUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking-space")
public class ParkingSpaceController {

  private final CreateParkingSpaceUseCase createParkingSpaceUseCase;
  private final GetAllParkingSpacesUseCase getAllParkingSpacesUseCase;
  private final ParkingMapper parkingMapper;

  public ParkingSpaceController(CreateParkingSpaceUseCase createParkingSpaceUseCase,
                                GetAllParkingSpacesUseCase getAllParkingSpacesUseCase, ParkingMapper parkingMapper) {
    this.createParkingSpaceUseCase = createParkingSpaceUseCase;
    this.getAllParkingSpacesUseCase = getAllParkingSpacesUseCase;
    this.parkingMapper = parkingMapper;
  }

  @PostMapping("/create")
  public ResponseEntity<ParkingSpaceResponse> create( @RequestBody ParkingSpaceRequest parkingSpaceRequest) {
    CreateParkingSpaceCommand command = new CreateParkingSpaceCommand(
        parkingSpaceRequest.getType(),
        parkingSpaceRequest.getNumber()
    );
    ParkingSpace parkingSpace = createParkingSpaceUseCase.execute(command);

    return ResponseEntity.ok(new ParkingSpaceResponse(parkingSpace));
  }

  @GetMapping("/get-all")
  public ResponseEntity<List<ParkingSpaceResponse>> getParkingSpaces(){

    List<ParkingSpace> parkingSpaces = getAllParkingSpacesUseCase.execute();

    List<ParkingSpaceResponse> response = parkingMapper.toResponseList(parkingSpaces);

    return ResponseEntity.ok(response);
  }
}
