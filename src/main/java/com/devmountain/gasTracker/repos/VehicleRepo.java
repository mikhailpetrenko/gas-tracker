package com.devmountain.gasTracker.repos;

import com.devmountain.gasTracker.entities.User;
import com.devmountain.gasTracker.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findAllByUserEquals(User user);

}
