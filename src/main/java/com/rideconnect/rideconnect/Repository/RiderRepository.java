package com.rideconnect.rideconnect.Repository;

import com.rideconnect.rideconnect.Models.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Integer> {

}
