package com.johnturkson.weather.service;

import com.johnturkson.weather.model.Alert;
import com.johnturkson.weather.model.City;
import com.johnturkson.weather.model.Weather;
import com.johnturkson.weather.model.WeatherData;

import java.io.UncheckedIOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WeatherService extends Service<Weather> {
    
    private final List<String> ids = List.of("time", "summary", "icon",
            "sunriseTime", "sunsetTime", "moonPhase",
            "nearestStormBearing", "nearestStormDistance",
            "precipIntensity", "precipIntensityError", "precipIntensityMax",
            "precipIntensityMaxTime", "precipProbability", "precipAccumulation", "precipType",
            "temperature", "temperatureHigh", "temperatureHighTime",
            "temperatureLow", "temperatureLowTime",
            "apparentTemperature", "apparentTemperatureHigh",
            "apparentTemperatureHighTime", "apparentTemperatureLow", "apparentTemperatureLowTime",
            "windSpeed", "windGust", "windGustTime", "windBearing",
            "uvIndex", "uvIndexTime",
            "visibility", "dewPoint", "humidity", "pressure", "cloudCover", "ozone");
    
    
    public WeatherService() {
        super(Key.WEATHER);
    }
    
    public WeatherService(Key key) {
        super(key);
    }
    
    public WeatherService(String key) {
        super(key);
    }
    
    @Override
    protected URL generateRequest(String query) {
        try {
            return new URL("https://api.darksky.net/forecast/" + key + "/" +
                    query + "?units=ca");
        } catch (MalformedURLException x) {
            // ignored - generated URL should be valid
            throw new UncheckedIOException(x);
        }
    }
    
    @Override
    protected Weather parseResponse(String response) throws ServiceException {
        // TODO handle parsing degree symbol
        // TODO implement HTTP response codes
        /*
        {"code":400,"error":"The given location is invalid."}
        "Forbidden" (403), "permission denied" (401)
        200 is OK
        429 = too many requests
         */
        
        City city;
        Pattern locationPattern = Pattern.compile("\"latitude\":(?<latitude>-?\\d+(?:.\\d+)?),\"longitude\":(?<longitude>-?\\d+(?:.\\d+)?)");
        Matcher locationMatcher = locationPattern.matcher(response);
        if (locationMatcher.find()) {
            List<City> cities = new GeocoderService().request(
                    locationMatcher.group("longitude") + ", " + locationMatcher.group("latitude"));
            if (cities.size() > 0) {
                city = cities.get(0);
            } else {
                throw new ServiceException("Error when obtaining city name from coordinates.");
            }
        } else {
            throw new ServiceException("Unable to parse city coordinates.");
        }
        
        WeatherData currentConditions;
        Pattern currentConditionsPattern = Pattern.compile("\"currently\":(?<currently>\\{[^{}]++})");
        Matcher currentConditionsMatcher = currentConditionsPattern.matcher(response);
        if (currentConditionsMatcher.find()) {
            currentConditions = parseCurrentConditions(currentConditionsMatcher.group("currently"));
        } else {
            // currentConditions is a required response field
            throw new ServiceException("Unable to parse current weather conditions.");
        }
        
        List<WeatherData> minutelyForecast;
        Pattern minutelyForecastPattern = Pattern.compile("\"minutely\":" +
                "(?<minutely>\\{\"summary\":\"[^\"]++\",\"icon\":\"[^\"]++\",\"data\":" +
                "\\[\\{[^{}]++}(?:,\\{[^{}]++})*+]})");
        Matcher minutelyForecastMatcher = minutelyForecastPattern.matcher(response);
        if (minutelyForecastMatcher.find()) {
            minutelyForecast = parseMinutelyForecast(minutelyForecastMatcher.group("minutely"));
        } else {
            // ignored - minutelyForecast is an optional response field
            minutelyForecast = new ArrayList<>();
        }
        
        List<WeatherData> hourlyForecast;
        Pattern hourlyForecastPattern = Pattern.compile("\"hourly\":(?<hourly>\\{\"summary\":\"" +
                ".+?\",\"icon\":\".+?\",\"data\":\\[\\{.+?}(?:,\\{.+?})*]})");
        Matcher hourlyForecastMatcher = hourlyForecastPattern.matcher(response);
        if (hourlyForecastMatcher.find()) {
            hourlyForecast = parseHourlyForecast(hourlyForecastMatcher.group("hourly"));
        } else {
            // ignored - hourlyForecast is an optional response field
            hourlyForecast = new ArrayList<>();
        }
        
        List<WeatherData> dailyForecast;
        Pattern dailyForecastPattern = Pattern.compile("\"daily\":(?<daily>\\{\"summary\":\"" +
                ".+?\",\"icon\":\".+?\",\"data\":\\[\\{.+?}(?:,\\{.+?})*]})");
        Matcher dailyForecastMatcher = dailyForecastPattern.matcher(response);
        if (dailyForecastMatcher.find()) {
            dailyForecast = parseDailyForecast(dailyForecastMatcher.group("daily"));
        } else {
            // ignored - dailyForecast is an optional response field
            dailyForecast = new ArrayList<>();
        }
        
        List<Alert> alerts;
        Pattern alertsPattern = Pattern.compile("\"alerts\":\\[(?<alerts>\\{.+?}(?:,\\{.+?})*)]");
        Matcher alertsMatcher = alertsPattern.matcher(response);
        if (alertsMatcher.find()) {
            alerts = parseAlerts(alertsMatcher.group("alerts"));
        } else {
            // ignored - alerts is an optional response field
            alerts = new ArrayList<>();
        }
        
        // TODO reverse geocode lat long coords into city name
        return Weather.of(city, response, currentConditions, minutelyForecast, hourlyForecast,
                dailyForecast, alerts);
    }
    
    private WeatherData parseCurrentConditions(String response) throws ServiceException {
        WeatherData.Builder currentConditionsBuilder = constructBuilderFrom(response);
        return currentConditionsBuilder.build();
    }
    
    
    private List<WeatherData> parseMinutelyForecast(String response) throws ServiceException {
        Pattern dataPattern = Pattern.compile("\\{\"summary\":" +
                "\"(?<summary>[^\"]++\"),\"icon\":" +
                "\"(?<icon>[^\"]++)\",\"data\":" +
                "\\[(?<data>[^]]++)]}");
        return parseForecastData(dataPattern, response);
    }
    
    private List<WeatherData> parseHourlyForecast(String response) throws ServiceException {
        Pattern dataPattern = Pattern.compile("\\{\"summary\":" +
                "\"(?<summary>[^\"]++\"),\"icon\":" +
                "\"(?<icon>[^\"]++)\",\"data\":" +
                "\\[(?<data>[^]]++)]}");
        return parseForecastData(dataPattern, response);
    }
    
    private List<WeatherData> parseDailyForecast(String response) throws ServiceException {
        Pattern dataPattern = Pattern.compile("\\{\"summary\":" +
                "\"(?<summary>[^\"]++\"),\"icon\":" +
                "\"(?<icon>[^\"]++)\",\"data\":" +
                "\\[(?<data>[^]]++)]}");
        return parseForecastData(dataPattern, response);
    }
    
    private List<WeatherData> parseForecastData(Pattern dataPattern, String response) throws ServiceException {
        List<WeatherData> weatherData = new ArrayList<>();
        
        String data;
        Matcher dataMatcher = dataPattern.matcher(response);
        
        if (dataMatcher.find()) {
            data = dataMatcher.group("data");
        } else {
            throw new ServiceException("Unable to parse data points in forecast.");
        }
        
        Pattern forecastPattern = Pattern.compile("\\{(?<nextMinute>[^}]++)}");
        Matcher forecastMatcher = forecastPattern.matcher(data);
        
        while (forecastMatcher.find()) {
            String nextMinute = forecastMatcher.group("nextMinute");
            WeatherData.Builder nextMinuteConditionsBuilder = constructBuilderFrom(nextMinute);
            weatherData.add(nextMinuteConditionsBuilder.build());
        }
        return weatherData;
    }
    
    private WeatherData.Builder constructBuilderFrom(String response) {
        WeatherData.Builder builder = new WeatherData.Builder();
        for (String id : ids) {
            String value;
            Pattern valuePattern = Pattern.compile("\"" + id + "\":\"?" + "(?<" + id + ">" +
                    "(?:\\d+(?:\\.\\d+)?)|(?:[^\"]+))" + "\"?");
            Matcher valueMatcher = valuePattern.matcher(response);
            if (valueMatcher.find()) {
                value = valueMatcher.group(id);
                try {
                    builder.getClass()
                            .getDeclaredMethod(id, String.class).
                            invoke(builder, value);
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return builder;
    }
    
    private List<Alert> parseAlerts(String response) {
        List<Alert> alerts = new ArrayList<>();
        
        Pattern alertPattern = Pattern.compile("\\{(?<alert>.+?)}");
        Matcher alertMatcher = alertPattern.matcher(response);
        
        while (alertMatcher.find()) {
            String alertBody = alertMatcher.group("alert");
            
            String title;
            Pattern titlePattern = Pattern.compile("\"title\":\"(?<title>.+?)\"");
            Matcher titleMatcher = titlePattern.matcher(alertBody);
            if (titleMatcher.find()) {
                title = titleMatcher.group("title");
            } else {
                System.err.println("Unable to parse alert title.");
                continue;
            }
            
            List<String> regions;
            Pattern regionsPattern = Pattern.compile("\"regions\":\\[(?<regions>.+?)]");
            Matcher regionsMatcher = regionsPattern.matcher(alertBody);
            if (regionsMatcher.find()) {
                regions = Arrays.stream(regionsMatcher.group("regions").split(","))
                        .map(s -> s.substring(1, s.length() - 1))
                        .collect(Collectors.toCollection(ArrayList::new));
            } else {
                System.err.println("Unable to parse alert regions.");
                continue;
            }
            
            String severity;
            Pattern severityPattern = Pattern.compile("\"severity\":\"(?<severity>.+?)\"");
            Matcher severityMatcher = severityPattern.matcher(alertBody);
            if (severityMatcher.find()) {
                severity = severityMatcher.group("severity");
            } else {
                System.err.println("Unable to parse alert severity.");
                continue;
            }
            
            String time;
            Pattern timePattern = Pattern.compile("\"time\":(?<time>\\d+)");
            Matcher timeMatcher = timePattern.matcher(alertBody);
            if (timeMatcher.find()) {
                time = timeMatcher.group("time");
            } else {
                System.err.println("Unable to parse alert time.");
                continue;
            }
            
            String expires;
            Pattern expiresPattern = Pattern.compile("\"expires\":(?<expires>\\d+)");
            Matcher expiresMatcher = expiresPattern.matcher(alertBody);
            if (expiresMatcher.find()) {
                expires = expiresMatcher.group("expires");
            } else {
                System.err.println("Unable to parse alert expiry.");
                continue;
            }
            
            String description;
            Pattern descriptionPattern = Pattern.compile("\"description\":\"(?<description>.+?)\"");
            Matcher descriptionMatcher = descriptionPattern.matcher(alertBody);
            if (descriptionMatcher.find()) {
                description = descriptionMatcher.group("description");
            } else {
                System.err.println("Unable to parse alert description.");
                continue;
            }
            
            String uri;
            Pattern uriPattern = Pattern.compile("\"uri\":\"(?<uri>.+?)\"");
            Matcher uriMatcher = uriPattern.matcher(alertBody);
            if (uriMatcher.find()) {
                uri = uriMatcher.group("uri");
            } else {
                System.err.println("Unable to parse alert uri.");
                continue;
            }
            
            alerts.add(new Alert(title, regions, severity, time, expires, description, uri));
        }
        
        return alerts;
    }
}
