package com.rideconnect.rideconnect.Controller;

import com.rideconnect.rideconnect.Models.Driver_Offer;
import com.rideconnect.rideconnect.Service.Driver_OfferService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/driver_offer")
public class Driver_offerController {

    private final Driver_OfferService driver_offerService;


    public Driver_offerController(Driver_OfferService driver_offerService) {
        this.driver_offerService = driver_offerService;
    }
    @PostMapping("/accept_offer")
    public Driver_Offer accept_offer(@Param("offer_id") Integer offer_id, @Param("driver_id") Integer driver_id) {
        return driver_offerService.acceptOffer(offer_id, driver_id);
    }
}
