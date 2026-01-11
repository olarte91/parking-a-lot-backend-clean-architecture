package com.katusoft.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "registers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RegisterEntity {

  @Id
  private UUID id;

  @Column(name = "license_plate", nullable = false)
  private String licensePlate;

  @Column(name = "vehicle_type", nullable = false)
  private String vehicleType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parkingspace_id", nullable = false)
  private ParkingSpaceEntity parkingSpace;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  @Column(name = "total_price")
  private double totalPrice;

  @Column(nullable = false)
  private LocalDateTime entrance;

  @Column
  private LocalDateTime departure;
}