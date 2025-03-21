package com.rideconnect.rideconnect.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RiderRepository {
    private final JdbcTemplate jdbcTemplate;

    public RiderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
