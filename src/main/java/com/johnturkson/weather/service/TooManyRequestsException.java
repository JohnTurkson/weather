package com.johnturkson.weather.service;

public class TooManyRequestsException extends ServiceException {
    public TooManyRequestsException(String message) {
        super(message);
    }
}
