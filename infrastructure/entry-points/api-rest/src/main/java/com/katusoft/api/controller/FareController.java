package com.katusoft.api.controller;

import com.katusoft.api.dto.FareRequest;
import com.katusoft.api.dto.FareResponse;
import com.katusoft.model.fare.Fare;
import com.katusoft.usecase.createfare.CreateFareCommand;
import com.katusoft.usecase.createfare.CreateFareUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fare")
public class FareController {

  private final CreateFareUseCase createFareUseCase;

  public FareController(CreateFareUseCase createFareUseCase) {
    this.createFareUseCase = createFareUseCase;
  }

  @PostMapping("/create")
  public ResponseEntity<FareResponse> createFare(@RequestBody FareRequest request){
    CreateFareCommand command = new CreateFareCommand(request.getType(), request.getAmount());
    Fare fare = createFareUseCase.execute(command);

    return ResponseEntity.ok(new FareResponse(fare));
  }
}
