package com.devmountain.gasTracker.controllers;

import com.devmountain.gasTracker.dtos.VehicleDto;
import com.devmountain.gasTracker.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/vehicles")

public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/user/{userId}")
    public List<VehicleDto> getVehicleByUser(@PathVariable Long userId) {
        return vehicleService.getAllVehiclesById(userId);
    }
    @PostMapping("/user/{userId}")
    public void addVehicle(@RequestBody VehicleDto vehicleDto, @PathVariable Long userId) {
        vehicleService.addVehicle(vehicleDto, userId);
    }

    @DeleteMapping("/{songId}")
    public void deleteVehicleById(@PathVariable Long vehicleId) {
        vehicleService.deleteVehicleById(vehicleId);
    }
    @PostMapping
    public void updateVehicle(@RequestBody VehicleDto vehicleDto) {
        vehicleService.updateVehicleById(vehicleDto);
    }

    public Optional<VehicleDto> getVehicleById(Long vehicleId) {
        return vehicleService.getVehicleById(vehicleId);
    }

}
