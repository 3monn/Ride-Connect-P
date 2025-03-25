package com.rideconnect.rideconnect.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_type")
public class Vehicle_Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vtypeid")
    private Integer vtype_ID; // Changed from Vehicle_ID to vtype_ID to better match table column
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "base_fare")
    private Integer base_fare;
    
    @Column(name = "fare_multiplier")
    private Integer fare_multiplier;

    public Vehicle_Type() {
    }

    public Vehicle_Type(Integer vtype_ID, String name, String description, Integer base_fare,
                        Integer fare_multiplier) {
        this.vtype_ID = vtype_ID;
        this.name = name;
        this.description = description;
        this.base_fare = base_fare;
        this.fare_multiplier = fare_multiplier;
    }

    public Integer getVtype_ID() {
        return vtype_ID;
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
