package com.johnturkson.weather.service;

public class UncheckedServiceException extends RuntimeException {
    public UncheckedServiceException() {
        super();
    }
    
    public UncheckedServiceException(String message) {
        super(message);
    }
}
