package com.rideconnect.rideconnect.Service;

import com.rideconnect.rideconnect.Entities.Driver_Offer;
import com.rideconnect.rideconnect.Entities.Ride;
import com.rideconnect.rideconnect.Repository.Driver_OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Driver_OfferService {
    private final Driver_OfferRepository driver_offerRepository;

    public Driver_OfferService(Driver_OfferRepository driverOfferRepository) {
        driver_offerRepository = driverOfferRepository;
    }
    public Driver_Offer accept_offer(int offer_id, int driver_id) {
        return driver_offerRepository.accept_offer(offer_id, driver_id);
    }

    public Driver_Offer save(Driver_Offer driver_offer) {
        return driver_offerRepository.save(driver_offer);
    }
    public Driver_Offer send_offer_to_drivers(Ride ride) {
        return driver_offerRepository.save(new Driver_Offer(ride));
    }

    public List<Driver_Offer> find_all_pending_offers(){
        return driver_offerRepository.find_all_pending_offers();
    }
}
