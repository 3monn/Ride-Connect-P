package com.rideconnect.rideconnect.Entities;

import com.rideconnect.rideconnect.Entities.Types.Point;

import java.sql.Timestamp;

public class Ride {
    private Integer Ride_ID;
    private Integer Rider_ID; // foreign key
    private Integer Driver_ID; // foreign key
    private Integer Surge_ID; // foreign key, nullable
    private String status;
    private Point pickup_location;
    private Point dropoff_location;
    private Timestamp pickup_time;
    private Timestamp dropoff_time;
    private double distance;
    private double estimated_duration;
    private double duration;
    private double estimated_fare;
    private double actual_fare;
    private Timestamp created_at;
    private Point[] route;
    private double total_ride_fare;

    public Ride() {
    }

    public Ride(Integer ride_ID, Integer rider_ID, Integer driver_ID, Integer surge_ID, String status,
                Point pickup_location, Point dropoff_location, Timestamp pickup_time, Timestamp dropoff_time,
                double distance, double estimated_duration, double duration, double estimated_fare, double actual_fare,
                Timestamp created_at, Point[] route, double total_ride_fare) {
        Ride_ID = ride_ID;
        Rider_ID = rider_ID;
        Driver_ID = driver_ID;
        Surge_ID = surge_ID;
        this.status = status;
        this.pickup_location = pickup_location;
        this.dropoff_location = dropoff_location;
        this.pickup_time = pickup_time;
        this.dropoff_time = dropoff_time;
        this.distance = distance;
        this.estimated_duration = estimated_duration;
        this.duration = duration;
        this.estimated_fare = estimated_fare;
        this.actual_fare = actual_fare;
        this.created_at = created_at;
        this.route = route;
        this.total_ride_fare = total_ride_fare;
    }

    public Integer getRide_ID() {
        return Ride_ID;
    }

    public Integer getRider_ID() {
        return Rider_ID;
    }

    public void setRider_ID(Integer rider_ID) {
        Rider_ID = rider_ID;
    }

    public Integer getDriver_ID() {
        return Driver_ID;
    }

    public void setDriver_ID(Integer driver_ID) {
        Driver_ID = driver_ID;
    }

    public Integer getSurge_ID() {
        return Surge_ID;
    }

    public void setSurge_ID(Integer surge_ID) {
        Surge_ID = surge_ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Point getPickup_location() {
        return pickup_location;
    }

    public void setPickup_location(Point pickup_location) {
        this.pickup_location = pickup_location;
    }

    public Point getDropoff_location() {
        return dropoff_location;
    }

    public void setDropoff_location(Point dropoff_location) {
        this.dropoff_location = dropoff_location;
    }

    public Timestamp getPickup_time() {
        return pickup_time;
    }

    public void setPickup_time(Timestamp pickup_time) {
        this.pickup_time = pickup_time;
    }

    public Timestamp getDropoff_time() {
        return dropoff_time;
    }

    public void setDropoff_time(Timestamp dropoff_time) {
        this.dropoff_time = dropoff_time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getEstimated_duration() {
        return estimated_duration;
    }

    public void setEstimated_duration(double estimated_duration) {
        this.estimated_duration = estimated_duration;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getEstimated_fare() {
        return estimated_fare;
    }

    public void setEstimated_fare(double estimated_fare) {
        this.estimated_fare = estimated_fare;
    }

    public double getActual_fare() {
        return actual_fare;
    }

    public void setActual_fare(double actual_fare) {
        this.actual_fare = actual_fare;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Point[] getRoute() {
        return route;
    }

    public void setRoute(Point[] route) {
        this.route = route;
    }

    public double getTotal_ride_fare() {
        return total_ride_fare;
    }

    public void setTotal_ride_fare(double total_ride_fare) {
        this.total_ride_fare = total_ride_fare;
    }
}
