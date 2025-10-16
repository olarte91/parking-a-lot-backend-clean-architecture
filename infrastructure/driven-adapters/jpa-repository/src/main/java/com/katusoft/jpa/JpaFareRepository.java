package com.katusoft.jpa;

import com.katusoft.jpa.entity.FareEntity;
import com.katusoft.model.fare.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.UUID;

public interface JpaFareRepository extends CrudRepository<FareEntity, UUID>, QueryByExampleExecutor<FareEntity> {

  boolean existsByType(Type type);
}
