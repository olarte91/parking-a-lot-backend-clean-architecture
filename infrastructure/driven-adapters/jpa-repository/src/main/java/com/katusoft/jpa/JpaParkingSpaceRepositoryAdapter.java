package com.katusoft.jpa;

import com.katusoft.jpa.entity.ParkingSpaceEntity;
import com.katusoft.jpa.helper.AdapterOperations;
import com.katusoft.model.fare.Type;
import com.katusoft.model.parkingspace.ParkingSpace;
import com.katusoft.model.parkingspace.gateways.ParkingSpaceRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaParkingSpaceRepositoryAdapter extends AdapterOperations<ParkingSpace, ParkingSpaceEntity, UUID, JpaParkingSpaceRepository>
    implements ParkingSpaceRepository {

  public JpaParkingSpaceRepositoryAdapter(JpaParkingSpaceRepository repository, ObjectMapper mapper) {
    /**
     *  Could be use mapper.mapBuilder if your domain model implement builder pattern
     *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
     *  Or using mapper.map with the class of the object model
     */
    super(repository, mapper, d -> mapper.map(d, ParkingSpace.class));
  }

  @Override
  public ParkingSpace createParkingSpace(ParkingSpace parkingSpace) {
    ParkingSpaceEntity saved = repository.save(toEntity(parkingSpace));
    return toDomain(saved);
  }

  @Override
  public List<ParkingSpace> findAll() {
    List<ParkingSpaceEntity> entities = (List<ParkingSpaceEntity>) repository.findAll();

    return entities.stream()
        .map(entity -> new ParkingSpace(
            entity.getId(),
            entity.getType(),
            entity.getNumber(),
            entity.getStatus()
        ))
        .toList();
  }

  @Override
  public Optional<ParkingSpace> findById(int id) {
    return Optional.empty();
  }

  @Override
  public Optional<ParkingSpace> findAvailableByType(Type type) {
    return Optional.empty();
  }

  @Override
  public List<ParkingSpace> findAllAvailable() {
    return List.of();
  }

  @Override
  public void deleteById(UUID id) {

  }

  @Override
  public long countByType(Type type) {
    return 0;
  }

  @Override
  public boolean existsById(UUID id) {
    return false;
  }

  @Override
  public boolean existsByNumber(int number) {
    return false;
  }

  @Override
  public boolean isAvailable(int number) {
    return false;
  }

  private ParkingSpaceEntity toEntity(ParkingSpace parkingSpace) {
    return ParkingSpaceEntity.builder()
        .id(parkingSpace.getId())
        .status(parkingSpace.getStatus())
        .number(parkingSpace.getParkingSpacenumber())
        .type(parkingSpace.getType())
        .build();
  }

  private ParkingSpace toDomain(ParkingSpaceEntity parkingSpaceEntity) {
    return new ParkingSpace(
        parkingSpaceEntity.getType(),
        parkingSpaceEntity.getNumber()
    );
  }
}
