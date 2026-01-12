package com.katusoft.model.register.gateways;

import com.katusoft.model.register.Register;

import java.util.List;
import java.util.Optional;

public interface RegisterRepository {

  Register save(Register register);
  List<Register> findAll();
  Optional<Register> findActiveByLicensePlate(String licensePlate);
}
