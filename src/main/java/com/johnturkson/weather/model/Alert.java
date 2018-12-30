package com.johnturkson.weather.model;

import java.util.List;

public class Alert {
    private String title;
    private List<String> regions;
    private String severity;
    private String time;
    private String expires;
    private String description;
    private String uri;
    
    public Alert(String title, List<String> regions, String severity, String time, String expires, String description, String uri) {
        this.title = title;
        this.regions = regions;
        this.severity = severity;
        this.time = time;
        this.expires = expires;
        this.description = description;
        this.uri = uri;
    }
    
    public String getTitle() {
        return title;
    }
    
    public List<String> getRegions() {
        return regions;
    }
    
    public String getSeverity() {
        return severity;
    }
    
    public String getTime() {
        return time;
    }
    
    public String getExpires() {
        return expires;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getUri() {
        return uri;
    }
    
    @Override
    public String toString() {
        return String.format("%s\nAffected Regions: %s\nSeverity: %s\nIssued: %s\nExpires: %s\n" +
                        "%s\nFor more information, visit %s",
                title,
                regions,
                severity,
                time,
                expires,
                description,
                uri);
    }
}
