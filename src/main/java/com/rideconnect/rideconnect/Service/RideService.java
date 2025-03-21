package com.rideconnect.rideconnect.Service;

import java.util.Random;

import com.rideconnect.rideconnect.Entities.Driver_Offer;
import com.rideconnect.rideconnect.Entities.Ride;
import com.rideconnect.rideconnect.Service.Driver_OfferService;
import com.rideconnect.rideconnect.Repository.RideRepository;
import org.springframework.stereotype.Service;

@Service
public class RideService {
    private final RideRepository rideRepository;
    private final Driver_OfferService driverOfferService;


    RideService(RideRepository rideRepository,Driver_OfferService driverOfferService) {
        this.rideRepository = rideRepository;
        this.driverOfferService = driverOfferService;

    }

    public Ride rideRequest(Ride ride, int ride_type) {//ride type -> saver, premium, standard
        if (!validate(ride)) {
            System.out.println("Ride not valid");
            return ride; //ride not valid
        }
        ride.setEstimated_fare(calculateFare(ride, ride_type)); // or calculateFare2 !
        rideRepository.save(ride);
        driverOfferService.send_offer_to_drivers(ride);
        return ride;
    }


    private boolean validate(Ride ride) {
        //code to validate ride -> we won't write it just assume its there, its there for the logic
        //maybe validate distance?: distance > 1 km, distance < 100 km ?,
        // are there roads near pickup and dropoff points?

        //if not valid throw exception -> illegalstateexception
        if(ride.getDistance() > 50 || ride.getDistance() < 1)
            return false;

        return true;
    }

    // not sure if this is the best implementation -------------------------!!!!!!!!!!!!!!!!! maybe ENUM ?
    private double calculateFare(Ride ride, int ride_type) { //genarate random fare
        Random rand = new Random();
        return switch (ride_type) {
            case 1 -> (Math.round(rand.nextDouble(10, 100) * 100.0) / 100.0) * 0.9; //saver
            case 2 -> Math.round(rand.nextDouble(10, 100) * 100.0) / 100.0; //standard
            case 3 -> (Math.round(rand.nextDouble(10, 100) * 100.0) / 100.0) * 1.1; //premium
            default ->
                    throw new IllegalStateException("Couldn't Generate Fare, Ride type: " + ride_type + " not found");
        };
    }

    private double calculateFare2(Ride ride, int ride_type) { //genarate random fare
        Random rand = new Random();
        double multiplyer = rideRepository.getFare(ride_type);
        return switch (ride_type) {
            case 1 -> multiplyer * ride.getDistance() * 0.9; //saver
            case 2 -> multiplyer * ride.getDistance();       //standard
            case 3 -> multiplyer * ride.getDistance() * 1.1; //premium
            default ->
                    throw new IllegalStateException("Couldn't Generate Fare, Ride type: " + ride_type + " not found");
        };
    }


}
