package com.johnturkson.weather.model;

import java.util.List;

public class Weather {
    private City city;
    private String rawData;
    private WeatherData currentConditions;
    private List<WeatherData> minutelyForecast;
    private List<WeatherData> hourlyForecast;
    private List<WeatherData> dailyForecast;
    private List<Alert> alerts;
    
    private Weather(City city, String rawData, WeatherData currentConditions,
                    List<WeatherData> minutelyForecast,
                    List<WeatherData> hourlyForecast, List<WeatherData> dailyForecast,
                    List<Alert> alerts) {
        this.city = city;
        this.rawData = rawData;
        this.currentConditions = currentConditions;
        this.minutelyForecast = minutelyForecast;
        this.hourlyForecast = hourlyForecast;
        this.dailyForecast = dailyForecast;
        this.alerts = alerts;
    }
    
    public static Weather of(City city, String rawData, WeatherData currentConditions,
                             List<WeatherData> minutelyForecast,
                             List<WeatherData> hourlyForecast, List<WeatherData> dailyForecast,
                             List<Alert> alerts) {
        return new Weather(city, rawData, currentConditions, minutelyForecast, hourlyForecast,
                dailyForecast, alerts);
    }
    
    public City getCity() {
        return city;
    }
    
    public String getRawData() {
        return rawData;
    }
    
    public WeatherData getCurrentConditions() {
        return currentConditions;
    }
    
    public List<WeatherData> getMinutelyForecast() {
        return minutelyForecast;
    }
    
    public List<WeatherData> getHourlyForecast() {
        return hourlyForecast;
    }
    
    public List<WeatherData> getDailyForecast() {
        return dailyForecast;
    }
    
    public List<Alert> getAlerts() {
        return alerts;
    }
    
    @Override
    public String toString() {
        return "Weather{" +
                "city=" + city +
                ", rawData='" + rawData + '\'' +
                ", currentConditions=" + currentConditions +
                ", minutelyForecast=" + minutelyForecast +
                ", hourlyForecast=" + hourlyForecast +
                ", dailyForecast=" + dailyForecast +
                ", alerts=" + alerts +
                '}';
    }
}