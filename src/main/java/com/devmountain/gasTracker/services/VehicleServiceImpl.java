package com.devmountain.gasTracker.services;

import com.devmountain.gasTracker.dtos.VehicleDto;
import com.devmountain.gasTracker.entities.User;
import com.devmountain.gasTracker.entities.Vehicle;
import com.devmountain.gasTracker.repos.UserRepo;
import com.devmountain.gasTracker.repos.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public void addVehicle(VehicleDto vehicleDto, Long userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        Vehicle vehicle = new Vehicle(vehicleDto);
        userOptional.ifPresent(vehicle::setUser);
        vehicleRepo.saveAndFlush(vehicle);
    }

    @Override
    public void deleteVehicleById(Long vehicleId) {
        Optional<Vehicle> vehicleOptional = vehicleRepo.findById(vehicleId);
        vehicleOptional.ifPresent(vehicle -> vehicleRepo.delete(vehicle));

    }

    @Override
    public void updateVehicleById(VehicleDto vehicleDto) {
        Optional<Vehicle> vehicleOptional = vehicleRepo.findById(vehicleDto.getId());
        vehicleOptional.ifPresent(vehicle -> {
            vehicle.setVehicleName(vehicleDto.getVehicleName());
            vehicleRepo.saveAndFlush(vehicle);
        });

    }

    @Override
    public List<VehicleDto> getAllVehiclesById(Long userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isPresent()) {
            List<Vehicle> vehicleList = vehicleRepo.findAllByUserEquals(userOptional.get());
            return vehicleList.stream().map(VehicleDto::new).collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<VehicleDto> getVehicleById(Long vehicleId) {
        Optional<Vehicle> vehicleOptional = vehicleRepo.findById(vehicleId);
        return vehicleOptional.map(VehicleDto::new);
    }
}
