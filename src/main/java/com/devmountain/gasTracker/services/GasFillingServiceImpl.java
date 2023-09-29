package com.devmountain.gasTracker.services;

import com.devmountain.gasTracker.dtos.GasFillingDto;
import com.devmountain.gasTracker.entities.GasFilling;
import com.devmountain.gasTracker.entities.Vehicle;
import com.devmountain.gasTracker.repos.GasFillingRepo;
import com.devmountain.gasTracker.repos.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GasFillingServiceImpl implements GasFillingService {
    @Autowired
    private GasFillingRepo gasFillingRepo;

    @Autowired
    private VehicleRepo vehicleRepo;

    @Override
    public void addGasFilling(GasFillingDto gasFillingDto, Long vehicleId) {
        Optional<Vehicle> vehicleOptional = vehicleRepo.findById(vehicleId);
        GasFilling gasFilling = new GasFilling(gasFillingDto);
        vehicleOptional.ifPresent(gasFilling::setVehicle);
        gasFillingRepo.saveAndFlush(gasFilling);
    }

    @Override
    public void deleteGasFillingById(Long gasFillingId) {
        Optional<GasFilling> gasFillingOptional = gasFillingRepo.findById(gasFillingId);
        gasFillingOptional.ifPresent(gasFilling -> gasFillingRepo.delete(gasFilling));
    }

    @Override
    public void updateGasFillingById(GasFillingDto gasFillingDto, Long gasFillingId) {
        Optional<GasFilling> gasFillingOptional = gasFillingRepo.findById(gasFillingDto.getId());
        gasFillingOptional.ifPresent(gasFilling -> {
            gasFilling.setDate(gasFillingDto.getDate());
            gasFilling.setFillingVolume(gasFillingDto.getFillingVolume());
            gasFilling.setCurrentMileage(gasFillingDto.getCurrentMileage());
            gasFillingRepo.saveAndFlush(gasFilling);
        });
    }

    @Override
    public Optional<GasFillingDto> getGasFillingById(Long gasFillingId) {
        return Optional.empty();
    }

    @Override
    public List<GasFillingDto> getAllGasFillingsByVehicle(Long vehicleId) {
        Optional<Vehicle> vehicleOptional = vehicleRepo.findById(vehicleId);
        if (vehicleOptional.isPresent()) {
            List<GasFilling> gasFillingList = gasFillingRepo.findAllByVehicle(vehicleOptional.get());
            return gasFillingList.stream().map(GasFillingDto::new).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
