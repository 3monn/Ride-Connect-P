package com.rideconnect.rideconnect.Converters;

import com.rideconnect.rideconnect.Models.Types.Point;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

@Converter
public class PointArrayConverter implements AttributeConverter<Point[], String> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    public String convertToDatabaseColumn(Point[] attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (Exception e) {
            return "[]";
        }
    }
    
    @Override
    public Point[] convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, Point[].class);
        } catch (IOException e) {
            return new Point[0];
        }
    }
}

