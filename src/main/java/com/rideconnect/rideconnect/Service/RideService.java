package com.rideconnect.rideconnect.Service;

import java.sql.Timestamp;
import java.util.Random;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.rideconnect.rideconnect.Models.Driver_Offer;
import com.rideconnect.rideconnect.Models.Ride;
import com.rideconnect.rideconnect.Models.Rider;
import com.rideconnect.rideconnect.Repository.RideRepository;
import com.rideconnect.rideconnect.Repository.RiderRepository;

import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class RideService {
    private final RideRepository rideRepository;
    private final Driver_OfferService driverOfferService;
    private final RiderRepository riderRepository;
    
    
    RideService(RideRepository rideRepository, Driver_OfferService driverOfferService, RiderRepository riderRepository) {
        this.rideRepository = rideRepository;
        this.driverOfferService = driverOfferService;
        this.riderRepository = riderRepository;
    }

    @Transactional
    public Ride rideRequest(Ride ride, Integer ride_type) {// ride type -> saver, premium, standard

        if (!validate(ride)) {
            throw new IllegalStateException("Ride is not valid, did not pass validation");
        }
        
        //get the rider record
        Integer riderId = ride.getRider().getRider_ID();
        Rider rider = riderRepository.findById(riderId)
        .orElseThrow(() -> new IllegalStateException("Rider not found with ID: " + riderId));
        ride.setRider(rider);

        // set up ride data
        ride.setEstimated_fare(calculateFare(ride, ride_type));
        ride.setStatus("Pending");
        ride.setCreated_at(new Timestamp(System.currentTimeMillis()));

        //save ride to get id from db, since rideID is serial
        Ride savedRide = rideRepository.save(ride);

        //creating offer
        Driver_Offer driver_offer = new Driver_Offer(savedRide);
        driverOfferService.createOffersForNearDrivers(driver_offer);

        return savedRide;
    }

    @Transactional
    public Optional<Ride> findRideWithLock(Integer rideId) {
        return rideRepository.findRideWithLock(rideId);
    }
        private boolean validate(Ride ride) {
            
            if (ride.getDistance() > 50 || ride.getDistance() < 1)//maybe this check should happen in the frontend?
                return false; 

                
            if (ride.getRider() == null)
                return false;
                
            if (ride.getRider().getRider_ID() == null)
                return false;
                

            // are there roads near pickup and dropoff points?

            return true;
    }

    public Ride setStatus(String stat, Integer rideid) {
         return rideRepository.updateRideStatus(rideid, stat);
    }
   

    private double calculateFare(Ride ride, Integer ride_type) { // genarate fare based on distance
        double multiplyer = 1.4; // should be rideRepository.getFare(ride_type);

        //there should be a check to see if ride in surge area -> get surge multiplier from surge service 
        
        return switch (ride_type) {
            case 1 -> multiplyer * ride.getDistance() * 0.9; // saver
            case 2 -> multiplyer * ride.getDistance(); // standard
            case 3 -> multiplyer * ride.getDistance() * 1.1; // premium
            default ->
                throw new IllegalStateException("Couldn't Generate Fare, Ride type: " + ride_type + " not found");
        };
    }

    //a method to calculate distance beetween 2 points
    private double calculateDistance(Point point1, Point point2) {
        final int R = 6371000; // Earth radius in meters
        double lat1 = Math.toRadians(point1.getY());
        double lat2 = Math.toRadians(point2.getY());
        double lon1 = Math.toRadians(point1.getX());
        double lon2 = Math.toRadians(point2.getX());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;//meters
    }





}
