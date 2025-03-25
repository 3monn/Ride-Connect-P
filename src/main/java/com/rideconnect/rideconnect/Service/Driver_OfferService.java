package com.rideconnect.rideconnect.Service;

import com.rideconnect.rideconnect.Models.Driver_Offer;
import com.rideconnect.rideconnect.Repository.Driver_OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Driver_OfferService {
    private final Driver_OfferRepository driverOfferRepository;

    Driver_OfferService(Driver_OfferRepository driverOfferRepository) {
        this.driverOfferRepository = driverOfferRepository;
    }

    @SuppressWarnings("deprecation")
    public Driver_Offer acceptOffer(Integer offer_id, Integer driver_id) {
        Driver_Offer offer = driverOfferRepository.getById(offer_id);//if not found will throw exception !!!!!
        offer.setDriver_ID(driver_id);
        offer.setStatus("Accepted");
        return driverOfferRepository.save(offer);

    } 
    public Driver_Offer createOffer(Driver_Offer offer) {
        return driverOfferRepository.save(offer);
        
    }

    public Driver_Offer getOfferByID(Integer offerID) {
        return driverOfferRepository.findById(offerID).orElse(new Driver_Offer());
    }

    public void updateOffer(Driver_Offer offer) {
        driverOfferRepository.save(offer);
    }

    public void deleteOffer(Driver_Offer offer) {
        driverOfferRepository.delete(offer);
    }
    public void deleteOfferByID(Integer offerID) {
        driverOfferRepository.deleteById(offerID);
    }

    public List<Driver_Offer> findOffersByStatus(String status) {
        return driverOfferRepository.findByStatus(status);
    }
    
    @SuppressWarnings("deprecation") 
    public void updateStatus(String status, int offerID) {
        Driver_Offer offer = driverOfferRepository.getById(offerID);//if not found will throw exception !!!!!
        offer.setStatus(status);
        driverOfferRepository.save(offer);
    }
}
