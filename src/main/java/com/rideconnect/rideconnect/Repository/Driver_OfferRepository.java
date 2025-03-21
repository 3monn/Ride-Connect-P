package com.rideconnect.rideconnect.Repository;

import com.rideconnect.rideconnect.Entities.Driver_Offer;
import com.rideconnect.rideconnect.Entities.Ride;
import com.rideconnect.rideconnect.RowMapper.Driver_OfferMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Driver_OfferRepository {
    private final JdbcTemplate jdbcTemplate;
    Driver_OfferMapper driver_offerMapper = new Driver_OfferMapper();

    public Driver_OfferRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Driver_Offer save(Driver_Offer driver_offer) {
        //schema not available !!!!!!
        return driver_offer;
    }

    public Driver_Offer accept_offer(int offer_id, int driver_id) {
        String sql = "UPDATE driver_offer SET status = 'Accepted',driver_id = ? WHERE offer_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum)-> driver_offerMapper.mapRow(rs, rowNum), driver_id, offer_id);
    }

    public Driver_Offer send_offer_to_drivers(Ride ride) {
        //schema not available !!!!!!
        return new Driver_Offer();
    }

    public List<Driver_Offer> find_all_pending_offers() {//accepted, rejected, (pending)
        String sql = "SELECT * FROM driver_offer WHERE status = 'Pending'";
        return jdbcTemplate.query(sql, (rs, rowNum)-> driver_offerMapper.mapRow(rs, rowNum));
    }
}

