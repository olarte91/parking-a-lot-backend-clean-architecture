package com.katusoft.jpa;

import com.katusoft.jpa.entity.RegisterEntity;
import com.katusoft.jpa.helper.AdapterOperations;
import com.katusoft.jpa.mapper.RegisterMapper;
import com.katusoft.model.register.Register;
import com.katusoft.model.register.gateways.RegisterRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaRegisterRepositoryAdapter extends AdapterOperations<Register, RegisterEntity, UUID, JpaRegisterRepository>
    implements RegisterRepository {

  private final RegisterMapper registerMapper;

  public JpaRegisterRepositoryAdapter(JpaRegisterRepository repository, ObjectMapper mapper, RegisterMapper registerMapper) {
    /**
     *  Could be use mapper.mapBuilder if your domain model implement builder pattern
     *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
     *  Or using mapper.map with the class of the object model
     */
    super(repository, mapper, d -> mapper.map(d, Register.class));
    this.registerMapper = registerMapper;
  }

  @Override
  public Register save(Register register) {
    RegisterEntity entity = registerMapper.toEntity(register);
    return registerMapper.toDomain(repository.save(entity));
  }

  @Override
  public Register findByLicensePlate(String licensePlate) {
    return repository.findByLicensePlateAndDepartureIsNull(licensePlate)
        .map(registerMapper::toDomain)
        .orElse(null);
  }

  @Override
  public Optional<Register> findActiveByLicensePlate(String licensePlate) {
    return repository.findByLicensePlateAndDepartureIsNull(licensePlate)
        .map(registerMapper::toDomain);
  }
}
