package com.katusoft.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "vehicle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehicleEntity {

  @Id
  @Column(name = "license_plate")
  private String licensePlate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fare_id", nullable = false)
  private FareEntity fare;
}
