package com.katusoft.jpa;

import com.katusoft.jpa.entity.FareEntity;
import com.katusoft.jpa.helper.AdapterOperations;
import com.katusoft.model.fare.Fare;
import com.katusoft.model.fare.Type;
import com.katusoft.model.fare.gateways.FareRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaFareRepositoryAdapter extends AdapterOperations<Fare, FareEntity, UUID, JpaFareRepository>
    implements FareRepository {

  public JpaFareRepositoryAdapter(JpaFareRepository repository, ObjectMapper mapper) {
    /**
     *  Could be use mapper.mapBuilder if your domain model implement builder pattern
     *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
     *  Or using mapper.map with the class of the object model
     */
    super(repository, mapper, d -> mapper.map(d, Fare.class));
  }

  @Override
  public Optional<Fare> findById(UUID id) {
    return Optional.empty();
  }

  @Override
  public Optional<Fare> findByType(Type type) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(UUID id) {
    return repository.existsById(id);
  }

  @Override
  public boolean existsByType(Type type) {
    return repository.existsByType(type);
  }

  @Override
  public Fare createFare(Fare fare) {
    FareEntity entity = toEntity(fare);
    FareEntity saved = repository.save(entity);
    return toDomain(saved);
  }

  @Override
  public void deleteById(UUID id) {

  }

  private FareEntity toEntity(Fare fare){
    FareEntity entity = new FareEntity();

    entity.setId(fare.getId());
    entity.setType(fare.getFareType());
    entity.setValuePerHour(fare.getValuePerHour());
    return entity;
  }

  private Fare toDomain(FareEntity entity){
    return new Fare(
        entity.getId(),
        entity.getType(),
        entity.getValuePerHour()
    );
  }
}
