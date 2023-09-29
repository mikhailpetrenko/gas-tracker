package com.devmountain.gasTracker.services;

import com.devmountain.gasTracker.dtos.VehicleDto;
import com.devmountain.gasTracker.entities.Vehicle;
import com.devmountain.gasTracker.repos.VehicleRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    @Transactional
    void addVehicle(VehicleDto vehicleDto, Long userId);
    @Transactional
    void deleteVehicleById(Long vehicleId);

    @Transactional
    void updateVehicleById(VehicleDto vehicleDto);
    List<VehicleDto> getAllVehiclesById(Long userId);
    Optional<VehicleDto> getVehicleById(Long vehicleId);

}
