package com.devmountain.gasTracker.dtos;

import com.devmountain.gasTracker.entities.GasFilling;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GasFillingDto implements Serializable {
    private Long id;
    private Long vehicleId;
    private Date date;
    private double fillingVolume;
    private double currentMileage;

    public GasFillingDto(GasFilling gasFilling) {
        if (gasFilling.getId() != null) {
            this.id = gasFilling.getId();
        }
        if (gasFilling.getFillingVolume() != 0) {
            this.fillingVolume = gasFilling.getFillingVolume();
        }
        if (gasFilling.getDate() != null) {
            this.date = gasFilling.getDate();
        }
        if (gasFilling.getVehicle() != null) {
            this.vehicleId = gasFilling.getVehicle();
        }
        if (gasFilling.getCurrentMileage() != 0) {
            this.currentMileage = gasFilling.getCurrentMileage();
        }

    }


}
