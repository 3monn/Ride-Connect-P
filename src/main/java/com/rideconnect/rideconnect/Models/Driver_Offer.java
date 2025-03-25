package com.rideconnect.rideconnect.Models;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "driver_offers")
public class Driver_Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offerid")
    private Integer Offer_ID;
    
    @Column(name = "driverid")
    private Integer Driver_ID; // foreign key
    
    @Column(name = "rideid")
    private Integer Ride_ID; // foreign key
    
    @Column(name = "acceptancestatus")
    private String status;
    
    @Column(name = "acceptancetime")
    private Timestamp Accept_Time;
    
    @Column(name = "distance_to_pickup")
    private double distance_to_pickup;

    public Driver_Offer() {
    }

    public Driver_Offer(Ride ride) {
        this.Ride_ID = ride.getRide_ID();
        this.status = "Pending";
        this.Accept_Time = null;
        this.distance_to_pickup = -1;
    }

    public Driver_Offer(Integer driver_ID, Integer ride_ID, String status, Timestamp accept_Time,
                        double distance_to_pickup) {
        Driver_ID = driver_ID;
        Ride_ID = ride_ID;
        this.status = status;
        Accept_Time = accept_Time;
        this.distance_to_pickup = distance_to_pickup;
    }

    public Integer getOffer_ID() {
        return Offer_ID;
    }

    public Integer getDriver_ID() {
        return Driver_ID;
    }

    public void setDriver_ID(Integer driver_ID) {
        Driver_ID = driver_ID;
    }

    public Integer getRide_ID() {
        return Ride_ID;
    }

    public void setRide_ID(Integer ride_ID) {
        Ride_ID = ride_ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getAccept_Time() {
        return Accept_Time;
    }

    public void setAccept_Time(Timestamp accept_Time) {
        Accept_Time = accept_Time;
    }

    public double getDistance_to_pickup() {
        return distance_to_pickup;
    }

    public void setDistance_to_pickup(double distance_to_pickup) {
        this.distance_to_pickup = distance_to_pickup;
    }
}
