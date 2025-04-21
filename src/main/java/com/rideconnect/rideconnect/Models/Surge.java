package com.rideconnect.rideconnect.Models;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

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

    @Column(name = "center_coordinate", columnDefinition = "geometry(POINT,4326)")
    private Point center_coordinate;

    @Column(name = "surge_area", columnDefinition = "geometry(POLYGON,4326)")
    private Polygon surgeArea;

    @Column(name = "diameter")
    private double diameter;

    public Surge() {
    }

    public Surge(Integer surge_id, Integer ride_id, double surge_multiplier, Point center_coordinate,
                 Polygon surgeArea, double diameter, String area_name) {
        this.surge_id = surge_id;
        this.ride_id = ride_id;
        this.surge_multiplier = surge_multiplier;
        this.center_coordinate = center_coordinate;
        this.surgeArea = surgeArea;
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

    public Polygon getSurgeArea() {
        return surgeArea;
    }

    public void setSurgeArea(Polygon surgeArea) {
        this.surgeArea = surgeArea;
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
