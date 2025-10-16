package com.katusoft.jpa.entity;

import com.katusoft.model.fare.Type;
import com.katusoft.model.parkingspace.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "parking_space")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ParkingSpaceEntity {

  @Id
  private UUID id;

  @Column
  @Enumerated(EnumType.STRING)
  private Type type;

  @Column
  private int number;

  @Column
  @Enumerated(EnumType.STRING)
  private Status status;
}
