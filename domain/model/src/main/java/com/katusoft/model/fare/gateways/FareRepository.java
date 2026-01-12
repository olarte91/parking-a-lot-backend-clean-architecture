package com.katusoft.model.fare.gateways;

import com.katusoft.model.fare.Fare;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FareRepository {
  //Búsquedas
  Optional<Fare> findById(UUID id);
  Optional<Fare> findByVehicleType(String type);
  List<Fare> findAll();

  //Verificaciones
  boolean existsByType(String type);

  //Persistencia
  Fare save(Fare fare);

  //Eliminación
  void deleteById(UUID id);

}
