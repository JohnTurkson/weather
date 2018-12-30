package com.johnturkson.weather.model;

import java.util.Objects;

public class City implements Comparable<City> {
    private String name;
    private String latitude;
    private String longitude;
    
    public City(String name, String latitude, String longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public String getName() {
        return name;
    }
    
    public String getLatitude() {
        return latitude;
    }
    
    public String getLongitude() {
        return longitude;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        City city = (City) o;
        
        return this.getName().equals(city.getName());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    
    @Override
    public String toString() {
        return name + " (" + latitude + ", " + longitude + ")";
    }
    
    @Override
    public int compareTo(City city) {
        return name.compareTo(city.getName());
    }
}
