package com.rideconnect.rideconnect.Entities;

import com.rideconnect.rideconnect.Entities.Types.Point;

public class Surge {
    private Integer surge_id;
    private Integer ride_id;
    private double surge_multiplier;
    private Point center_coordinate;
    private Point[] surge_area;
    private double diameter;

    public Surge() {
    }

    public Surge(Integer surge_id, Integer ride_id, double surge_multiplier, Point center_coordinate,
                 Point[] surge_area,
                 double diameter) {
        this.surge_id = surge_id;
        this.ride_id = ride_id;
        this.surge_multiplier = surge_multiplier;
        this.center_coordinate = center_coordinate;
        this.surge_area = surge_area;
        this.diameter = diameter;
    }

    public Integer getSurge_id() {
        return surge_id;
    }

    public Integer getRide_id() {
        return ride_id;
    }

    public void setRide_id(Integer ride_id) {
        this.ride_id = ride_id;
    }

    public double getSurge_multiplier() {
        return surge_multiplier;
    }

    public void setSurge_multiplier(double surge_multiplier) {
        this.surge_multiplier = surge_multiplier;
    }

    public Point getCenter_coordinate() {
        return center_coordinate;
    }

    public void setCenter_coordinate(Point center_coordinate) {
        this.center_coordinate = center_coordinate;
    }

    public Point[] getSurge_area() {
        return surge_area;
    }

    public void setSurge_area(Point[] surge_area) {
        this.surge_area = surge_area;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }
}
