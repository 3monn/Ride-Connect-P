package com.rideconnect.rideconnect.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicleid")
    private Integer Vehicle_ID;
    
    @Column(name = "vtypeid")
    private Integer Vehicle_Type_ID;
    
    @Column(name = "make")
    private String make;
    
    @Column(name = "model")
    private String model;
    
    @Column(name = "color")
    private String color;
    
    @Column(name = "plate")
    private String plate;
    
    @Column(name = "capacity")
    private Integer capacity;

    public Vehicle() {
    }

    public Vehicle(Integer vehicle_ID, Integer vehicle_Type_ID, String make, String model, String color, String plate,
                   Integer capacity) {
        Vehicle_ID = vehicle_ID;
        Vehicle_Type_ID = vehicle_Type_ID;
        this.make = make;
        this.model = model;
        this.color = color;
        this.plate = plate;
        this.capacity = capacity;
    }

    public Integer getVehicle_ID() {
        return Vehicle_ID;
    }

    public Integer getVehicle_Type_ID() {
        return Vehicle_Type_ID;
    }

    public void setVehicle_Type_ID(Integer vehicle_Type_ID) {
        Vehicle_Type_ID = vehicle_Type_ID;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
