package com.rideconnect.rideconnect.Service;

import com.rideconnect.rideconnect.Models.Driver;
import com.rideconnect.rideconnect.Models.Driver_Offer;
import com.rideconnect.rideconnect.Models.Ride;
import com.rideconnect.rideconnect.Repository.DriverRepository;
import com.rideconnect.rideconnect.Repository.Driver_OfferRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class Driver_OfferService {

    private final Driver_OfferRepository driverOfferRepository;
    private final RideService rideService;
    private final DriverRepository driverRepository;

    Driver_OfferService(RideService rideService,
            Driver_OfferRepository driverOfferRepository,
            DriverRepository driverRepository) {
        this.driverOfferRepository = driverOfferRepository;
        this.rideService = rideService;
        this.driverRepository = driverRepository;
    }

    @Transactional
    public Driver_Offer acceptOffer(Integer offer_id, Integer driver_id) {
        // Lock the offer row
        Driver_Offer offer = driverOfferRepository.findIdWithLock(offer_id)
                .orElseThrow(() -> new IllegalStateException("Offer not found with id: " + offer_id));

        // Lock the ride row
        Ride ride = rideService.findRideWithLock(offer.getRide_ID())
                .orElseThrow(() -> new IllegalStateException("Ride not found with id: " + offer.getRide_ID()));

        // Check if the ride is already in progress
        if (!"Pending".equals(ride.getStatus())) {
            throw new IllegalStateException("Ride is not pending, cannot accept the offer");
        }

        // Update the offer
        offer.setDriver_ID(driver_id);
        offer.setStatus("Accepted");
        offer.setAccept_Time(new Timestamp(System.currentTimeMillis()));

        // Update the ride status
        rideService.setStatus("in Progress", ride.getRide_ID());

        return driverOfferRepository.save(offer);
    }

    public Driver_Offer createOffer(Driver_Offer offer) {
        return driverOfferRepository.save(offer);
    }

    @Transactional
    public List<Driver_Offer> createOffersForNearDrivers(Driver_Offer driver_Offer) {
        List<Driver> nearestDrivers = findNearestDrivers(driver_Offer.getRide_ID(), 5);
        List<Driver_Offer> createdOffers = new ArrayList<>();

        for (Driver driver : nearestDrivers) {
            Driver_Offer offer = new Driver_Offer();
            offer.setRide_ID(driver_Offer.getRide_ID());
            offer.setDriver_ID(driver.getDriver_ID());
            offer.setStatus("Pending");

            createdOffers.add(driverOfferRepository.save(offer));
        }
        return createdOffers;
    }

    public Driver_Offer getOfferByID(Integer offerID) {
        return driverOfferRepository.findById(offerID).orElse(new Driver_Offer());
    }

    public List<Driver_Offer> getAllOffers() {
        return driverOfferRepository.findAll();
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
        Driver_Offer offer = driverOfferRepository.getById(offerID);// if not found will throw exception !!!!!
        offer.setStatus(status);
        driverOfferRepository.save(offer);
    }

    public List<Driver> findNearestDrivers(int rideid, int limit) {
        return driverRepository.findNearestAvailableDrivers(rideid, limit);
    }
}
