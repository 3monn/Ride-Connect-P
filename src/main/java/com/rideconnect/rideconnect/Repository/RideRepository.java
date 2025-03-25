package com.rideconnect.rideconnect.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rideconnect.rideconnect.Models.Ride;

@Repository
public interface RideRepository extends JpaRepository<Ride, Integer> {

  @Query("SELECT vt.fare_multiplier FROM Vehicle_Type vt WHERE vt.vtype_ID = :rideType")
    Double getFare(@Param("rideType") int rideType);
}
