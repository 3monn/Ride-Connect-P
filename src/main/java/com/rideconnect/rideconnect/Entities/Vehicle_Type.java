package com.rideconnect.rideconnect.Entities;

public class Vehicle_Type {
    private Integer Vehicle_ID; //nullable -> database genarates serial id;
    private String name;
    private String description;
    private Integer base_fare;
    private Integer fare_multiplier;

    public Vehicle_Type() {
    }

    public Vehicle_Type(Integer vehicle_ID, String name, String description, Integer base_fare,
                        Integer fare_multiplier) {
        Vehicle_ID = vehicle_ID;
        this.name = name;
        this.description = description;
        this.base_fare = base_fare;
        this.fare_multiplier = fare_multiplier;
    }

    public Integer getVehicle_ID() {
        return Vehicle_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBase_fare() {
        return base_fare;
    }

    public void setBase_fare(Integer base_fare) {
        this.base_fare = base_fare;
    }

    public Integer getFare_multiplier() {
        return fare_multiplier;
    }

    public void setFare_multiplier(Integer fare_multiplier) {
        this.fare_multiplier = fare_multiplier;
    }
}
