package com.katusoft.jpa;

import com.katusoft.jpa.entity.RegisterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;
import java.util.UUID;

public interface JpaRegisterRepository extends CrudRepository<RegisterEntity, UUID>, QueryByExampleExecutor<RegisterEntity> {

  Optional<RegisterEntity> findByLicensePlateAndDepartureIsNull(String licensePlate);

}
