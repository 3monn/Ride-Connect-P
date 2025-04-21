package com.rideconnect.rideconnect.util;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.geom.LinearRing;

// Class to convert custom Point (com.rideconnect.rideconnect.Models.Types.Point) objects to PostGIS geometries using JTS.

// JTS (Java Topology Suite): https://github.com/locationtech/jts
// JTS is a Java library for creating and manipulating vector geometry objects like Point, LineString, and Polygon.

// GeometryFactory definition from the official JTS documentation:
// Source: https://locationtech.github.io/jts/javadoc/org/locationtech/jts/geom/GeometryFactory.html
// "Supplies a set of utility methods for building Geometry objects from lists of Coordinates."

//Additonally we implemented method calculateDdistance which calculate distance between 2 points
//and is point inside surge

public class GeometryUtil {
    // GeometryFactory from above comments
    private static final GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

    // Coordinate -> JTS point
    public static Point sendPointToDb(Coordinate coord) {
        Point pt = geometryFactory.createPoint(coord);
        return pt;
    }

    // JTS point -> Coordinate
    public static Coordinate readPointFromDb(Point pt) {
        if (pt == null)
            return null;
        return pt.getCoordinate();
    }

    // Array of coordinates -> JTS LineString
    public static LineString sendLineToDb(Coordinate[] coords) {
        if (coords == null || coords.length == 0)
            return null;
        LineString line = geometryFactory.createLineString(coords);
        return line;
    }

    // JTS LineString -> Array of coordinates
    public static Coordinate[] readLineFromDb(LineString line) {
        if (line == null)
            return null;
        return line.getCoordinates();
    }

    // Need to check with d7oom, polygon size is fixed with 5 points?
    // if polygon points is fixed -> if polygon not closed no need to create a new
    // one

    // Array of coordinates -> JTS Polygon + ensuring closure
    public static Polygon sendPolygonToDb(Coordinate[] coords) {
        if (coords == null || coords.length < 4)
            return null;
        if (!coords[0].equals2D(coords[coords.length - 1])) { // first point != last point?
            Coordinate[] closed = new Coordinate[coords.length + 1];
            System.arraycopy(coords, 0, closed, 0, coords.length);
            closed[coords.length] = new Coordinate(coords[0]);
            coords = closed;
        }
        LinearRing shell = geometryFactory.createLinearRing(coords);
        Polygon poly = geometryFactory.createPolygon(shell);
        return poly;
    }

    // JTS Polygon -> Array of coordinates
    public static Coordinate[] readPolygonFromDb(Polygon poly) {
        if (poly == null)
            return null;
        return poly.getExteriorRing().getCoordinates();
    }

    public static double calculateDistance(Point point1, Point point2) {
        final int R = 6371000; // Earth radius in meters
        double lat1 = Math.toRadians(point1.getY());
        double lat2 = Math.toRadians(point2.getY());
        double lon1 = Math.toRadians(point1.getX());
        double lon2 = Math.toRadians(point2.getX());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;//meters
    }

}