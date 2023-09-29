package com.devmountain.gasTracker.services;

import com.devmountain.gasTracker.dtos.GasFillingDto;

import java.util.List;
import java.util.Optional;

public interface GasFillingService {
    void addGasFilling(GasFillingDto gasFillingDto, Long vehicleId);
    void deleteGasFillingById(Long gasFillingId);
    void updateGasFillingById(GasFillingDto gasFillingDto, Long gasFillingId);
    Optional<GasFillingDto> getGasFillingById(Long gasFillingId);
    List<GasFillingDto> getAllGasFillingsByVehicle(Long vehicleId);

}
