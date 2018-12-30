package com.johnturkson.weather.ui;

import com.johnturkson.weather.model.City;
import com.johnturkson.weather.model.Weather;
import com.johnturkson.weather.service.GeocoderService;
import com.johnturkson.weather.service.ServiceException;
import com.johnturkson.weather.service.WeatherService;

public class Main {
    public static void main(String[] args) throws ServiceException {
        GeocoderService geocoder = new GeocoderService();
        WeatherService weather = new WeatherService();
        
        City vancouver = geocoder.request("Vancouver").get(0);
        
        Weather test = weather.request(vancouver.getLatitude() + "," + vancouver.getLongitude());
        System.out.println(test);
    }
}