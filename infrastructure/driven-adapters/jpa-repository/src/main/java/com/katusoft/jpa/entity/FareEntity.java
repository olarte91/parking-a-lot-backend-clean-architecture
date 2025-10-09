package com.katusoft.jpa.entity;

import com.katusoft.model.fare.FareType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "fare")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FareEntity {

  @Id
  @Column(name = "id")
  private UUID id;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, unique = true, name = "fare_type")
  private FareType fareType;

  @Column(name = "value_per_hour")
  private double valuePerHour;
}
