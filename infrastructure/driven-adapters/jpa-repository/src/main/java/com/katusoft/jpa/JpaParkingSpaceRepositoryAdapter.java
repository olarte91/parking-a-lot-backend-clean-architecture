package com.katusoft.jpa;

import com.katusoft.jpa.entity.ParkingSpaceEntity;
import com.katusoft.jpa.helper.AdapterOperations;
import com.katusoft.jpa.mapper.ParkingSpaceMapper;
import com.katusoft.model.exception.ParkingSpaceNotFoundException;
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

  private final ParkingSpaceMapper newMapper;

  public JpaParkingSpaceRepositoryAdapter(JpaParkingSpaceRepository repository, ObjectMapper mapper, ParkingSpaceMapper newMapper) {
    /**
     *  Could be use mapper.mapBuilder if your domain model implement builder pattern
     *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
     *  Or using mapper.map with the class of the object model
     */
    super(repository, mapper, d -> mapper.map(d, ParkingSpace.class));
    this.newMapper = newMapper;
  }

  @Override
  public ParkingSpace save(ParkingSpace parkingSpace) {
    ParkingSpaceEntity saved = repository.save(newMapper.toEntity(parkingSpace));
    return newMapper.toDomain(saved);
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
  public Optional<ParkingSpace> findByNumber(Integer number) {
    return Optional.ofNullable(newMapper.toDomain(repository.findByNumber(number)
        .orElseThrow(() -> new ParkingSpaceNotFoundException("Parking space with number " + number + " not found"))));
  }

  @Override
  public boolean isNumberAvailable(int number) {
    return repository.existsByNumber(number);
  }


}
