package com.katusoft.jpa;

import com.katusoft.jpa.entity.FareEntity;
import com.katusoft.jpa.entity.VehicleEntity;
import com.katusoft.jpa.helper.AdapterOperations;
import com.katusoft.model.vehicle.Vehicle;
import com.katusoft.model.vehicle.gateways.VehicleRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaVehicleRepositoryAdapter extends AdapterOperations<Vehicle, VehicleEntity, String, JpaVehicleRepository>
    implements VehicleRepository {

  public JpaVehicleRepositoryAdapter(JpaVehicleRepository repository, ObjectMapper mapper) {
    /**
     *  Could be use mapper.mapBuilder if your domain model implement builder pattern
     *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
     *  Or using mapper.map with the class of the object model
     */
    super(repository, mapper, d -> mapper.map(d, Vehicle.class));
  }

  @Override
  public Vehicle saveVehicle(Vehicle vehicle) {
    VehicleEntity entity = toEntity(vehicle);
    VehicleEntity savedVehicle = repository.save(entity);
    return toDomain(savedVehicle);
  }

  @Override
  public Optional<Vehicle> findByLicensePlate(String licensePlate) {
    return Optional.empty();
  }

  @Override
  public boolean existsByLicensePlate(String licensePlate) {
    return false;
  }

  @Override
  public void deleteByLicensePlate(String licensePlate) {

  }

  private VehicleEntity toEntity(Vehicle vehicle){
    VehicleEntity entity = new VehicleEntity();

    entity.setLicensePlate(vehicle.getLicensePlate());

    if(vehicle.getFareId() != null){
      FareEntity fareReference = new FareEntity();
      fareReference.setId(vehicle.getFareId());
      entity.setFare(fareReference);
    }
    return entity;
  }

  private Vehicle toDomain(VehicleEntity entity){
    return Vehicle.create(
        entity.getLicensePlate(),
        entity.getFare() != null ? entity.getFare().getId() :  null
    );
  }
}
