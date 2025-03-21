package com.rideconnect.rideconnect.Entities;

import com.rideconnect.rideconnect.Entities.Types.Point;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

public class Driver {
    private Integer Driver_ID; //nullable -> database genarates serial id;
    private String name;
    private String phone;
    private String email;
    private String status; //???
    private Integer Vehicle_id; //foreign key
    private String license;

    //-----------------------------------
    //to reprensent the location of the driver point or geometry
    private Point location;
    private Timestamp last_update;
    //-----------------------------------

    public Driver() {
    }

    public Driver(Integer driver_ID, String name, String phone, String email, String status, Integer vehicle_id,
                  String license, Point location, Timestamp last_update) {
        Driver_ID = driver_ID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.status = status;
        Vehicle_id = vehicle_id;
        this.license = license;
        this.location = location;
        this.last_update = last_update;
    }

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

    public Integer getVehicle_id() {
        return Vehicle_id;
    }

    public void setVehicle_id(Integer vehicle_id) {
        Vehicle_id = vehicle_id;
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
