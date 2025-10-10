package com.katusoft.jpa;

import com.katusoft.jpa.entity.VehicleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;


public interface JpaVehicleRepository extends CrudRepository<VehicleEntity, String>, QueryByExampleExecutor<VehicleEntity> {

}
