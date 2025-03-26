package com.rideconnect.rideconnect.Service;

import java.sql.Timestamp;
import java.util.Random;

import jakarta.transaction.Transactional;

import com.rideconnect.rideconnect.Models.Driver_Offer;
import com.rideconnect.rideconnect.Models.Ride;
import com.rideconnect.rideconnect.Models.Rider;
import com.rideconnect.rideconnect.Repository.RideRepository;
import com.rideconnect.rideconnect.Repository.RiderRepository;

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

        Integer riderId = ride.getRider().getRider_ID();
      
        Rider rider = riderRepository.findById(riderId)
        .orElseThrow(() -> new IllegalStateException("Rider not found with ID: " + riderId));
        ride.setRider(rider);

        // set up ride
        ride.setEstimated_fare(calculateFare2(ride, ride_type));
        ride.setStatus("Pending");
        ride.setCreated_at(new Timestamp(System.currentTimeMillis()));

        //save ride to get id from db, since its serial
        Ride savedRide = rideRepository.save(ride);

        //creating offer
        Driver_Offer driver_offer = new Driver_Offer(savedRide);
        driverOfferService.createOffer(driver_offer);

        return savedRide;
    }

        

        private boolean validate(Ride ride) {
            if (ride.getDistance() > 50 || ride.getDistance() < 1)
                return false;
                
            if (ride.getRider() == null)
                return false;
                
            if (ride.getRider().getRider_ID() == null)
                return false;
                

            // are there roads near pickup and dropoff points?

            return true;
    }

    @SuppressWarnings("unused")
    private double calculateFare(Ride ride, Integer ride_type) { // genarate random fare
        Random rand = new Random();
        
        //is ride in surge area ? -> get surge multiplier from surge service 

        return switch (ride_type) {
            case 1 -> (Math.round(rand.nextDouble(10, 100) * 100.0) / 100.0) * 0.9; // saver
            case 2 -> Math.round(rand.nextDouble(10, 100) * 100.0) / 100.0; // standard
            case 3 -> (Math.round(rand.nextDouble(10, 100) * 100.0) / 100.0) * 1.1; // premium
            default ->
                throw new IllegalStateException("Couldn't Generate Fare, Ride type: " + ride_type + " not found");
        };
    }

    private double calculateFare2(Ride ride, Integer ride_type) { // genarate fare based on distance
        double multiplyer = 1.4; // should be rideRepository.getFare(ride_type);

        //is ride in surge area ? -> get surge multiplier from surge service 
        
        return switch (ride_type) {
            case 1 -> multiplyer * ride.getDistance() * 0.9; // saver
            case 2 -> multiplyer * ride.getDistance(); // standard
            case 3 -> multiplyer * ride.getDistance() * 1.1; // premium
            default ->
                throw new IllegalStateException("Couldn't Generate Fare, Ride type: " + ride_type + " not found");
        };
    }

}
