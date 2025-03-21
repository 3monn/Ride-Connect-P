package com.rideconnect.rideconnect.Repository;

import com.rideconnect.rideconnect.Entities.Ride;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RideRepository {
    private final JdbcTemplate jdbcTemplate;


    public RideRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Ride save(Ride ride){
        //schema not available !!!!!!
        return ride;
    }

    public Double getFare(int ride_type){
        String sql = "SELECT fare FROM ride_type WHERE ride_type = ?";
        return jdbcTemplate.queryForObject(sql, Double.class, ride_type);
    }
}
