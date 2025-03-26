package com.rideconnect.rideconnect.Models;

import jakarta.persistence.*;
import java.sql.Timestamp;
import com.rideconnect.rideconnect.Models.Types.Point;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverid")
    private Integer Driver_ID;
    

    @Column(name = "name")
    private String name;
    
    @Column(name = "phone_number")
    private String phone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "status")
    private String status;
    
    @ManyToOne // A driver has one vehicle, but a vehicle can be used by many drivers
    @JoinColumn(name = "vehicleid")
    private Vehicle vehicle;
    
    @Column(name = "license")
    private String license;
    
    @Embedded
    private Point location;
    
    @Column(name = "last_update")
    private Timestamp last_update;

    public Driver() {
    }

    public Driver(Integer driver_ID, String name, String phone, String email, String status, Vehicle vehicle,
                  String license, Point location, Timestamp last_update) {
        Driver_ID = driver_ID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.vehicle = vehicle;
        this.license = license;
        this.location = location;
        this.last_update = last_update;
    }

    // Getters and setters
    public Integer getDriver_ID() {
        return Driver_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }
}
