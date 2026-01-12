package com.katusoft.jpa;

import com.katusoft.jpa.entity.FareEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;
import java.util.UUID;

public interface JpaFareRepository extends CrudRepository<FareEntity, UUID>, QueryByExampleExecutor<FareEntity> {

  Optional<FareEntity> findByType(String type);
}
