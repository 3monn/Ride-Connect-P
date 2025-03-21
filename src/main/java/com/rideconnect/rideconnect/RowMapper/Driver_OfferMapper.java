package com.rideconnect.rideconnect.RowMapper;

import com.rideconnect.rideconnect.Entities.Driver_Offer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Driver_OfferMapper implements RowMapper {
    @Override
    public Driver_Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Driver_Offer(
                rs.getInt("driver_id"),
                rs.getInt("ride_id"),
                rs.getString("status"),
                rs.getTimestamp("accept_time"),
                rs.getDouble("distance_to_pickup")
        );
    }
}
