package com.rideconnect.rideconnect.Entities;

import com.rideconnect.rideconnect.Entities.Types.Point;

import java.util.Date;

public class Rider {
    private Integer Rider_ID; //nullable -> database genarates serial id;
    private String name;
    private String phone;
    private String email;
    //-----------------------------------
    //to reprensent the location of the rider point or geometry
    private Point location;
    private Date last_update;
    //-----------------------------------

    public Rider() {
    }

    public Rider(Integer rider_ID, String name, String phone, String email, Point location, Date last_update) {
        Rider_ID = rider_ID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.location = location;
        this.last_update = last_update;
    }

    public Integer getRider_ID() {
        return Rider_ID;
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

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}
