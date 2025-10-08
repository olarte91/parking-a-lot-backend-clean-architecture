package com.katusoft.model.fare.gateways;

import com.katusoft.model.fare.Fare;
import com.katusoft.model.fare.FareType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FareRepository {
  //Búsquedas
  Optional<Fare> findById(UUID id);
  Optional<Fare> findByType(FareType fareType);
  List<Fare> findAll();

  //Verificaciones
  boolean existsById(UUID id);
  boolean existsByType(FareType fareType);

  //Persistencia
  Fare save(Fare fare);

  //Eliminación
  void deleteById(UUID id);

}
