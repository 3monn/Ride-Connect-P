package com.rideconnect.rideconnect.Models;

import com.rideconnect.rideconnect.Converters.PointArrayConverter;
import com.rideconnect.rideconnect.Models.Types.Point;
import jakarta.persistence.*;

@Entity
@Table(name = "surge")
public class Surge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "surgeid")
    private Integer surge_id;
    
    @Column(name = "area_name")
    private String area_name;
    
    @Column(name = "rideid")
    private Integer ride_id;
    
    @Column(name = "surge_multiplier")
    private double surge_multiplier;
    
    @Embedded
    private Point center_coordinate;
    
    @Convert(converter = PointArrayConverter.class)
    @Column(name = "surge_area", columnDefinition = "TEXT")
    private Point[] surge_area;
    
    @Column(name = "diameter")
    private double diameter;

    public Surge() {
    }

    public Surge(Integer surge_id, Integer ride_id, double surge_multiplier, Point center_coordinate,
                 Point[] surge_area, double diameter, String area_name) {
        this.surge_id = surge_id;
        this.ride_id = ride_id;
        this.surge_multiplier = surge_multiplier;
        this.center_coordinate = center_coordinate;
        this.surge_area = surge_area;
        this.diameter = diameter;
        this.area_name = area_name;
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

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }
}
