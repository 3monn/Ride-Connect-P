package com.rideconnect.rideconnect.Repository;

import com.rideconnect.rideconnect.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{

}
