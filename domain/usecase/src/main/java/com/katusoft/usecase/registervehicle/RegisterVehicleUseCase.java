package com.katusoft.usecase.registervehicle;

import com.katusoft.model.exception.IncompatibleVehicleTypeException;
import com.katusoft.model.exception.ParkingSpaceAlreadyOccupiedException;
import com.katusoft.model.exception.ParkingSpaceNotFoundException;
import com.katusoft.model.exception.UserNotFoundException;
import com.katusoft.model.exception.VehicleAlreadyExistsException;
import com.katusoft.model.parkingspace.ParkingSpace;
import com.katusoft.model.parkingspace.gateways.ParkingSpaceRepository;
import com.katusoft.model.register.Register;
import com.katusoft.model.register.VehicleType;
import com.katusoft.model.register.gateways.RegisterRepository;
import com.katusoft.model.user.User;
import com.katusoft.model.user.gateways.UserRepository;


public class RegisterVehicleUseCase {

  private final ParkingSpaceRepository parkingSpaceRepository;
  private final UserRepository userRepository;
  private final RegisterRepository registerRepository;

  public RegisterVehicleUseCase(ParkingSpaceRepository parkingSpaceRepository,
                                UserRepository userRepository,
                                RegisterRepository registerRepository) {
    this.parkingSpaceRepository = parkingSpaceRepository;
    this.userRepository = userRepository;
    this.registerRepository = registerRepository;
  }

  public Register execute(RegisterVehicleCommand command) {

    User user = userRepository.findUserById(command.getUserId())
        .orElseThrow(() -> new UserNotFoundException("User not found"));

    registerRepository.findActiveByLicensePlate(command.getLicensePlate())
        .ifPresent(r -> {
          throw new VehicleAlreadyExistsException("El vehículo con placa " + command.getLicensePlate() + " ya está en el parqueadero.");
        });

    if(!parkingSpaceRepository.isNumberAvailable(command.getParkingSpaceNumber())){
      throw new ParkingSpaceAlreadyOccupiedException("Parking space already occupied");
    }


    ParkingSpace parkingSpace = parkingSpaceRepository.findByNumber(command.getParkingSpaceNumber())
        .orElseThrow(() -> new ParkingSpaceNotFoundException("Parking space not found"));

    if (!parkingSpace.getType().name().equalsIgnoreCase(command.getVehicleType())) {
      throw new IncompatibleVehicleTypeException(
          "Cannot park a " + command.getVehicleType() + " in a " + parkingSpace.getType() + " space"
      );
    }

    parkingSpace.occupy();

    ParkingSpace occupiedParkingSpace = parkingSpaceRepository.save(parkingSpace);

    Register register = new Register(
        command.getLicensePlate(),
        occupiedParkingSpace,
        VehicleType.valueOf(command.getVehicleType().toUpperCase()),
        user
        );

    return registerRepository.save(register);
}
}
