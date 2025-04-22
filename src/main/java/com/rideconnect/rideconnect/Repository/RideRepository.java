package com.rideconnect.rideconnect.Repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rideconnect.rideconnect.Models.Ride;

@Repository
public interface RideRepository extends JpaRepository<Ride, Integer> {

  @Query("SELECT vt.fare_multiplier FROM Vehicle_Type vt WHERE vt.vtype_ID = :rideType")
  Double getFare(@Param("rideType") int rideType);

  @Transactional
  @Modifying
  @Query("update Ride r set r.status = :status where r.rideId = :rideId")
  Ride updateRideStatus(@Param("rideId") int rideId, @Param("status") String status);
}