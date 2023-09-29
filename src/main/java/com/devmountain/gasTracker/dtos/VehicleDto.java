package com.devmountain.gasTracker.dtos;


import com.devmountain.gasTracker.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VehicleDto implements Serializable {
    private Long id;
    private String vehicleName;
    private UserDto userDto;

    public VehicleDto(Vehicle vehicle) {
        if (vehicle.getId() != null) {
            this.id = vehicle.getId();
        }
        if (vehicle.getVehicleName() != null) {
            this.vehicleName = vehicle.getVehicleName();
        }
    }
}
