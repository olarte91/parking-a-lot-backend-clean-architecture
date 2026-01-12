package com.katusoft.jpa.mapper;

import com.katusoft.jpa.entity.FareEntity;
import com.katusoft.model.fare.Fare;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FareMapper {

  public FareEntity toEntity(Fare fare){
    FareEntity entity = new FareEntity();

    entity.setId(fare.getId());
    entity.setType(fare.getFareType());
    entity.setValuePerHour(fare.getValuePerHour());
    return entity;
  }

  public Fare toDomain(FareEntity entity){
    return new Fare(
        entity.getId(),
        entity.getType(),
        entity.getValuePerHour()
    );
  }
}
