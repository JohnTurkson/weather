package com.johnturkson.weather.service;

public class BadRequestException extends ServiceException {
    public BadRequestException(String message) {
        super(message);
    }
}
