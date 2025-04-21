package com.rideconnect.rideconnect.Controller;

import com.rideconnect.rideconnect.Models.Driver_Offer;
import com.rideconnect.rideconnect.Service.Driver_OfferService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/driver_offer")
public class Driver_offerController {

    private final Driver_OfferService driver_offerService;

    public Driver_offerController(Driver_OfferService driver_offerService) {
        this.driver_offerService = driver_offerService;
    }

    @GetMapping("/get_all_offers")
    public List<Driver_Offer> getAllOffers(){
        return driver_offerService.getAllOffers();
    }

    @PatchMapping("/accept_offer")
    public Driver_Offer accept_offer(@RequestParam("offer_id") Integer offer_id,
            @RequestParam("driver_id") Integer driver_id) {
        return driver_offerService.acceptOffer(offer_id, driver_id);
    }
    // http://localhost:8080/api/v1/driver_offer/accept_offer?offer_id=1&driver_id=1
}
