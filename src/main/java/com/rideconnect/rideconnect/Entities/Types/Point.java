package com.rideconnect.rideconnect.Entities.Types;

public class Point {
    Double longitude;
    Double latitude;
    Point(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
    Point() {
        this.longitude = 0.0;
        this.latitude = 0.0;
    }

}
