package com.devmountain.gasTracker.entities;

import com.devmountain.gasTracker.dtos.GasFillingDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "GasFillings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GasFilling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Long vehicle;

    @Column(name = "date")
    private Date date;

    @Column(name = "filling_volume")
    private double fillingVolume;

    @Column(name = "current_mileage")
    private double currentMileage;

    public GasFilling(GasFillingDto gasFillingDto) {
        if(gasFillingDto.getDate() != null) {
            this.date = gasFillingDto.getDate();
        }
        if(gasFillingDto.getFillingVolume() != 0) {
            this.fillingVolume = gasFillingDto.getFillingVolume();
        }
        if(gasFillingDto.getCurrentMileage() != 0) {
            this.currentMileage = gasFillingDto.getCurrentMileage();
        }
        if (gasFillingDto.getVehicleId() != null) {
            this.vehicle = gasFillingDto.getVehicleId();
        }
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle.getId();
    }
}
