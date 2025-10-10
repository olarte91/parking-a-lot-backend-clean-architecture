package com.katusoft.model.vehicle.gateways;

import com.katusoft.model.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {

  //Guardar o actualizar
  Vehicle saveVehicle(Vehicle vehicle);

  //Buscar por placa
  Optional<Vehicle> findByLicensePlate(String licensePlate);

  //Verificar existencia
  boolean existsByLicensePlate(String licensePlate);

  //Buscar todos
  List<Vehicle> findAll();

  //Eliminar por placa
  void deleteByLicensePlate(String licensePlate);
}
