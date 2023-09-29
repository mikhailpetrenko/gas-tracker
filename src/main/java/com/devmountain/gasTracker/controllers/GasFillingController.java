package com.devmountain.gasTracker.controllers;

import com.devmountain.gasTracker.dtos.GasFillingDto;
import com.devmountain.gasTracker.services.GasFillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/gasfilings")
public class GasFillingController {
    @Autowired
    private GasFillingService gasFillingService;

    @PostMapping("/vehicle/{vehicleId}")
    public void addGasFilling(@RequestBody GasFillingDto gasFillingDto, @PathVariable Long vehicleId) {
        gasFillingService.addGasFilling(gasFillingDto, vehicleId);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<GasFillingDto> getGasFillingsByVehicle(@PathVariable Long vehicleId) {
        return gasFillingService.getAllGasFillingsByVehicle(vehicleId);
    }

    @GetMapping("/{gasFillingId}")
    public Optional<GasFillingDto> getGasFillingById(@PathVariable Long gasFillingId) {
        return gasFillingService.getGasFillingById(gasFillingId);
    }

    @PutMapping("/{gasFillingId}")
    public void updateGasFilling(@RequestBody GasFillingDto gasFillingDto, @PathVariable Long gasFillingId) {
        gasFillingService.updateGasFillingById(gasFillingDto, gasFillingId);
    }

    @DeleteMapping("/{gasFillingId}")
    public void deleteGasFillingById(@PathVariable Long gasFillingId) {
        gasFillingService.deleteGasFillingById(gasFillingId);
    }
}
