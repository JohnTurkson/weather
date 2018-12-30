package com.johnturkson.weather.service;

import com.johnturkson.weather.model.City;

import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeocoderService extends Service<List<City>> {
    
    public GeocoderService() {
        super(Key.GEOCODER);
    }
    
    public GeocoderService(Key key) {
        super(key);
    }
    
    public GeocoderService(String key) {
        super(key);
    }
    
    @Override
    protected URL generateRequest(String query) {
        try {
            return new URL("https://api.mapbox.com/geocoding/v5/mapbox.places/" +
                    query + ".json?access_token=" + key +
                    "&types=place&autocomplete=false&limit=5");
        } catch (MalformedURLException x) {
            // ignored - generated URL should be valid
            throw new UncheckedIOException(x);
        }
    }
    
    @Override
    protected List<City> parseResponse(String response) {
        List<City> cities = new ArrayList<>();
        
        Pattern locationPattern = Pattern.compile("\"place_name\":\"(?<name>.+?)\".+?\"center\":" +
                "\\[(?<longitude>-?\\d+(?:\\.\\d+)?),(?<latitude>-?\\d+(?:\\.\\d+)?)]");
        Matcher locationMatcher = locationPattern.matcher(response);
        
        while (locationMatcher.find()) {
            cities.add(new City(locationMatcher.group("name"),
                    locationMatcher.group("latitude"), locationMatcher.group("longitude")));
        }
        return cities;
    }
}
