package com.katusoft.jpa;

import com.katusoft.jpa.entity.FareEntity;
import com.katusoft.jpa.helper.AdapterOperations;
import com.katusoft.jpa.mapper.FareMapper;
import com.katusoft.model.fare.Fare;
import com.katusoft.model.fare.gateways.FareRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaFareRepositoryAdapter extends AdapterOperations<Fare, FareEntity, UUID, JpaFareRepository>
    implements FareRepository {

  private final FareMapper fareMapper;

  public JpaFareRepositoryAdapter(JpaFareRepository repository, ObjectMapper mapper, FareMapper fareMapper) {
    /**
     *  Could be use mapper.mapBuilder if your domain model implement builder pattern
     *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
     *  Or using mapper.map with the class of the object model
     */
    super(repository, mapper, d -> mapper.map(d, Fare.class));
    this.fareMapper = fareMapper;
  }

  @Override
  public Optional<Fare> findByVehicleType(String type) {
    return repository.findByType(type)
        .map(fareMapper::toDomain);
  }

  @Override
  public Optional<Fare> findById(UUID id) {
    return repository.findById(id)
        .map(fareMapper::toDomain);
  }

  @Override
  public Fare save(Fare fare) {
    FareEntity entity = fareMapper.toEntity(fare);
    FareEntity saved = repository.save(entity);
    return fareMapper.toDomain(saved);
  }

  public boolean existsByType(String type) {
    return repository.findByType(type).isPresent();
  }

  @Override
  public void deleteById(UUID id) {
    repository.deleteById(id);
  }

}
