package com.devmountain.gasTracker.repos;

import com.devmountain.gasTracker.entities.GasFilling;
import com.devmountain.gasTracker.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GasFillingRepo extends JpaRepository<GasFilling,Long> {
    List<GasFilling> findAllByVehicle(Vehicle vehicle);

}
