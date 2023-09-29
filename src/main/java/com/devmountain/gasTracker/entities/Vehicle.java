package com.devmountain.gasTracker.entities;

import com.devmountain.gasTracker.dtos.VehicleDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Vehicles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Vehicle Name")
    private String vehicleName;

    @ManyToOne
    @JsonBackReference
    private User user;

    public Vehicle(VehicleDto vehicleDto) {
        if (vehicleDto.getVehicleName() != null) {
            this.vehicleName = vehicleDto.getVehicleName();
        }
    }
}
