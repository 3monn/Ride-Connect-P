package com.rideconnect.rideconnect.config;

import com.bedatadriven.jackson.datatype.jts.JtsModule;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

//Jackson is a Spring Boot dependency that handles converting Java objects to and from JSON.

/*
 * JacksonConfig makes sure that JTS geometry types (Point, LineString,etc.)
 * can be sent and received as JSON in our APIs.
 * Without this returning spatial data in API responses would not work properly.
 */
@Configuration
public class JacksonConfig {
    @Bean
    public JtsModule jtsModule() {
        return new JtsModule();
    }
}