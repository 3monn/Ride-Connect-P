package com.rideconnect.rideconnect.Models;

import jakarta.persistence.*;
import java.sql.Timestamp;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.LineString;

@Entity
@Table(name = "ride")
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rideid")
    private Integer Ride_ID;

    @ManyToOne
    @JoinColumn(name = "riderid")
    private Rider rider;

    @ManyToOne
    @JoinColumn(name = "surgeid")
    private Surge surge;

    private String status;

    @Column(name = "pickup_location", columnDefinition = "geometry(POINT,4326)")
    private Point pickupLocation;

    @Column(name = "dropoff_location", columnDefinition = "geometry(POINT,4326)")
    private Point dropoffLocation;

    @Column(name = "start_time")
    private Timestamp pickup_time;

    @Column(name = "dropoff_time")
    private Timestamp dropoff_time;

    private double distance;
    private double estimated_duration;
    private double duration;
    private double estimated_fare;
    private double actual_fare;
    private Timestamp created_at;

    @Column(columnDefinition = "geometry(LINESTRING,4326)")
    private LineString route;

    private double total_ride_fare;

    public Ride() {
    }

    public Ride(Integer ride_ID, Rider rider, Surge surge, String status,
            Point pickupLocation, Point dropoffLocation, Timestamp pickup_time, Timestamp dropoff_time,
            double distance, double estimated_duration, double duration, double estimated_fare, double actual_fare,
            Timestamp created_at, LineString route, double total_ride_fare) {
        Ride_ID = ride_ID;
        this.rider = rider;
        this.surge = surge;
        this.status = status;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
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

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Surge getSurge() {
        return surge;
    }

    public void setSurge(Surge surge) {
        this.surge = surge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Point getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Point pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Point getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(Point dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
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

    public LineString getRoute() {
        return route;
    }

    public void setRoute(LineString route) {
        this.route = route;
    }

    public double getTotal_ride_fare() {
        return total_ride_fare;
    }

    public void setTotal_ride_fare(double total_ride_fare) {
        this.total_ride_fare = total_ride_fare;
    }
}
