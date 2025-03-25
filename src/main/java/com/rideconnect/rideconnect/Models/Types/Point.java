package com.rideconnect.rideconnect.Models.Types;

import jakarta.persistence.Embeddable;

@Embeddable
public class Point {
    Double longitude;
    Double latitude;

    public Point(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Point() {
        this.longitude = 0.0;
        this.latitude = 0.0;
    }



    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
