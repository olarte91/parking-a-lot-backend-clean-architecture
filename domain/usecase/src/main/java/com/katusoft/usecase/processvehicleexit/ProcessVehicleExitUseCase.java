package com.katusoft.usecase.processvehicleexit;

import com.katusoft.model.exception.FareNotConfiguredException;
import com.katusoft.model.exception.VehicleNotRegisteredException;
import com.katusoft.model.fare.Fare;
import com.katusoft.model.fare.gateways.FareRepository;
import com.katusoft.model.parkingspace.gateways.ParkingSpaceRepository;
import com.katusoft.model.register.Register;
import com.katusoft.model.register.gateways.RegisterRepository;

import java.time.Duration;
import java.time.LocalDateTime;

public class ProcessVehicleExitUseCase {

  private final RegisterRepository registerRepository;
  private final ParkingSpaceRepository parkingSpaceRepository;
  private final FareRepository fareRepository;

  public ProcessVehicleExitUseCase(RegisterRepository registerRepository,
                                   ParkingSpaceRepository parkingSpaceRepository,
                                   FareRepository fareRepository) {
    this.registerRepository = registerRepository;
    this.parkingSpaceRepository = parkingSpaceRepository;
    this.fareRepository = fareRepository;
  }

  public Register execute(String licensePlate) {

    String normalizedPlate = licensePlate.toUpperCase().trim();

    Register register = registerRepository.findActiveByLicensePlate(normalizedPlate)
        .orElseThrow(() -> new VehicleNotRegisteredException("No se encontró un vehículo activo con la placa " + normalizedPlate));

    LocalDateTime exitDate = LocalDateTime.now();

    long billableHours = calculateBillableHours(register.getEntrance(), exitDate);

    Fare fare = fareRepository.findByVehicleType(register.getVehicleType().name())
        .orElseThrow(() -> new FareNotConfiguredException("Tarifa no configurada para: " + register.getVehicleType()));

    double totalPayable = billableHours * fare.getValuePerHour();

    register.setDeparture(exitDate);
    register.setTotalPrice(totalPayable);

    register.getParkingSpace().free();

    parkingSpaceRepository.save(register.getParkingSpace());
    return registerRepository.save(register);
  }

  private long calculateBillableHours(LocalDateTime entryDate, LocalDateTime exitDate) {

    Duration duration = Duration.between(entryDate, exitDate);
    long totalMinutes = duration.toMinutes();

    if (totalMinutes <= 0) {
      return 1;
    }

    return (long) Math.ceil(totalMinutes / 60.0);
  }
}