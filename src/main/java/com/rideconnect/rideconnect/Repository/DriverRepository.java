package com.rideconnect.rideconnect.Repository;

import com.rideconnect.rideconnect.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.locationtech.jts.geom.Point;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

  @Query(value = """
      SELECT d.*
      FROM driver d
      JOIN ride r ON r.ride_id = :rideId
      WHERE d.status = 'Available'
      ORDER BY ST_Distance(r.pickup_location, d.last_location)
      LIMIT :limit
      """,
      nativeQuery = true)
  List<Driver> findNearestAvailableDrivers(
      @Param("rideId") int rideId,
      @Param("limit")  int limit
  );
}


