package com.rideconnect.rideconnect.Repository;

import com.rideconnect.rideconnect.Models.Vehicle_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Vehicle_TypeRepository extends JpaRepository<Vehicle_Type, Integer> {


    @Query("SELECT v.fare_multiplier FROM Vehicle_Type v WHERE v.vtype_ID = :id")
    Double findFareMultiplierById(@Param("id") Integer id);

}
