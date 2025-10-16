package com.katusoft.jpa;

import com.katusoft.jpa.entity.ParkingSpaceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.UUID;

public interface JpaParkingSpaceRepository extends CrudRepository<ParkingSpaceEntity, UUID>, QueryByExampleExecutor<ParkingSpaceEntity> {

}
