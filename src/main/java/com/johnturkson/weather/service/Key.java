package com.johnturkson.weather.service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Key {
    public static final Key GEOCODER;
    public static final Key WEATHER;
    
    // Load keys from file
    private static final Path keyFolder = Paths
            .get(System.getProperty("user.home"))
            .resolve("Keys");
    private static final String geocoderKey;
    private static final String weatherKey;
    
    static {
        try {
            geocoderKey = Files.readString(keyFolder.resolve("mapbox.txt"));
            weatherKey = Files.readString(keyFolder.resolve("forecast.txt"));
            GEOCODER = new Key(geocoderKey);
            WEATHER = new Key(weatherKey);
        } catch (IOException x) {
            // ignored - file should exist locally
            throw new UncheckedIOException(x);
        }
    }
    
    
    private String key;
    
    public Key(String key) {
        this.key = key;
    }
    
    public Key key(String key) {
        this.key = key;
        return this;
    }
    
    public String getKey() {
        return key;
    }
}
