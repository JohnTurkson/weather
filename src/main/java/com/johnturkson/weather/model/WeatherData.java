package com.johnturkson.weather.model;

@SuppressWarnings("unused")
public class WeatherData {
    private String time;
    private String summary;
    private String icon;
    private String sunriseTime;
    private String sunsetTime;
    private String moonPhase;
    private String nearestStormBearing;
    private String nearestStormDistance;
    private String precipIntensity;
    private String precipIntensityError;
    private String precipIntensityMax;
    private String precipIntensityMaxTime;
    private String precipProbability;
    private String precipAccumulation;
    private String precipType;
    private String temperature;
    private String temperatureHigh;
    private String temperatureHighTime;
    private String temperatureLow;
    private String temperatureLowTime;
    private String apparentTemperature;
    private String apparentTemperatureHigh;
    private String apparentTemperatureHighTime;
    private String apparentTemperatureLow;
    private String apparentTemperatureLowTime;
    private String windSpeed;
    private String windGust;
    private String windGustTime;
    private String windBearing;
    private String uvIndex;
    private String uvIndexTime;
    private String visibility;
    private String dewPoint;
    private String humidity;
    private String pressure;
    private String cloudCover;
    private String ozone;
    
    private WeatherData(String time, String summary, String icon,
                        String sunriseTime, String sunsetTime, String moonPhase,
                        String nearestStormBearing, String nearestStormDistance,
                        String precipIntensity, String precipIntensityError,
                        String precipIntensityMax, String precipIntensityMaxTime,
                        String precipProbability, String precipAccumulation, String precipType,
                        String temperature, String temperatureHigh, String temperatureHighTime,
                        String temperatureLow, String temperatureLowTime,
                        String apparentTemperature,
                        String apparentTemperatureHigh, String apparentTemperatureHighTime,
                        String apparentTemperatureLow, String apparentTemperatureLowTime,
                        String windSpeed, String windGust, String windGustTime, String windBearing,
                        String uvIndex, String uvIndexTime,
                        String visibility, String dewPoint, String humidity, String pressure,
                        String cloudCover, String ozone) {
        
        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.moonPhase = moonPhase;
        this.nearestStormBearing = nearestStormBearing;
        this.nearestStormDistance = nearestStormDistance;
        this.precipIntensity = precipIntensity;
        this.precipIntensityError = precipIntensityError;
        this.precipIntensityMax = precipIntensityMax;
        this.precipIntensityMaxTime = precipIntensityMaxTime;
        this.precipProbability = precipProbability;
        this.precipAccumulation = precipAccumulation;
        this.precipType = precipType;
        this.temperature = temperature;
        this.temperatureHigh = temperatureHigh;
        this.temperatureHighTime = temperatureHighTime;
        this.temperatureLow = temperatureLow;
        this.temperatureLowTime = temperatureLowTime;
        this.apparentTemperature = apparentTemperature;
        this.apparentTemperatureHigh = apparentTemperatureHigh;
        this.apparentTemperatureHighTime = apparentTemperatureHighTime;
        this.apparentTemperatureLow = apparentTemperatureLow;
        this.apparentTemperatureLowTime = apparentTemperatureLowTime;
        this.windSpeed = windSpeed;
        this.windGust = windGust;
        this.windGustTime = windGustTime;
        this.windBearing = windBearing;
        this.uvIndex = uvIndex;
        this.uvIndexTime = uvIndexTime;
        this.visibility = visibility;
        this.dewPoint = dewPoint;
        this.humidity = humidity;
        this.cloudCover = cloudCover;
        this.pressure = pressure;
        this.ozone = ozone;
    }
    
    public String getTime() {
        return time;
    }
    
    public String getSummary() {
        return summary;
    }
    
    public String getIcon() {
        return icon;
    }
    
    public String getSunriseTime() {
        return sunriseTime;
    }
    
    public String getSunsetTime() {
        return sunsetTime;
    }
    
    public String getMoonPhase() {
        return moonPhase;
    }
    
    public String getNearestStormBearing() {
        return nearestStormBearing;
    }
    
    public String getNearestStormDistance() {
        return nearestStormDistance;
    }
    
    public String getPrecipIntensity() {
        return precipIntensity;
    }
    
    public String getPrecipIntensityError() {
        return precipIntensityError;
    }
    
    public String getPrecipIntensityMax() {
        return precipIntensityMax;
    }
    
    public String getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }
    
    public String getPrecipProbability() {
        return precipProbability;
    }
    
    public String getPrecipAccumulation() {
        return precipAccumulation;
    }
    
    public String getPrecipType() {
        return precipType;
    }
    
    public String getTemperature() {
        return temperature;
    }
    
    public String getTemperatureHigh() {
        return temperatureHigh;
    }
    
    public String getTemperatureHighTime() {
        return temperatureHighTime;
    }
    
    public String getTemperatureLow() {
        return temperatureLow;
    }
    
    public String getTemperatureLowTime() {
        return temperatureLowTime;
    }
    
    public String getApparentTemperature() {
        return apparentTemperature;
    }
    
    public String getApparentTemperatureHigh() {
        return apparentTemperatureHigh;
    }
    
    public String getApparentTemperatureHighTime() {
        return apparentTemperatureHighTime;
    }
    
    public String getApparentTemperatureLow() {
        return apparentTemperatureLow;
    }
    
    public String getApparentTemperatureLowTime() {
        return apparentTemperatureLowTime;
    }
    
    public String getWindSpeed() {
        return windSpeed;
    }
    
    public String getWindGust() {
        return windGust;
    }
    
    public String getWindGustTime() {
        return windGustTime;
    }
    
    public String getWindBearing() {
        return windBearing;
    }
    
    public String getUvIndex() {
        return uvIndex;
    }
    
    public String getUvIndexTime() {
        return uvIndexTime;
    }
    
    public String getVisibility() {
        return visibility;
    }
    
    public String getDewPoint() {
        return dewPoint;
    }
    
    public String getHumidity() {
        return humidity;
    }
    
    public String getPressure() {
        return pressure;
    }
    
    public String getCloudCover() {
        return cloudCover;
    }
    
    public String getOzone() {
        return ozone;
    }
    
    @Override
    public String toString() {
        return "WeatherData{" +
                "time='" + time + '\'' +
                ", summary='" + summary + '\'' +
                ", icon='" + icon + '\'' +
                ", sunriseTime='" + sunriseTime + '\'' +
                ", sunsetTime='" + sunsetTime + '\'' +
                ", moonPhase='" + moonPhase + '\'' +
                ", nearestStormBearing='" + nearestStormBearing + '\'' +
                ", nearestStormDistance='" + nearestStormDistance + '\'' +
                ", precipIntensity='" + precipIntensity + '\'' +
                ", precipIntensityError='" + precipIntensityError + '\'' +
                ", precipIntensityMax='" + precipIntensityMax + '\'' +
                ", precipIntensityMaxTime='" + precipIntensityMaxTime + '\'' +
                ", precipProbability='" + precipProbability + '\'' +
                ", precipAccumulation='" + precipAccumulation + '\'' +
                ", precipType='" + precipType + '\'' +
                ", temperature='" + temperature + '\'' +
                ", temperatureHigh='" + temperatureHigh + '\'' +
                ", temperatureHighTime='" + temperatureHighTime + '\'' +
                ", temperatureLow='" + temperatureLow + '\'' +
                ", temperatureLowTime='" + temperatureLowTime + '\'' +
                ", apparentTemperature='" + apparentTemperature + '\'' +
                ", apparentTemperatureHigh='" + apparentTemperatureHigh + '\'' +
                ", apparentTemperatureHighTime='" + apparentTemperatureHighTime + '\'' +
                ", apparentTemperatureLow='" + apparentTemperatureLow + '\'' +
                ", apparentTemperatureLowTime='" + apparentTemperatureLowTime + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", windGust='" + windGust + '\'' +
                ", windGustTime='" + windGustTime + '\'' +
                ", windBearing='" + windBearing + '\'' +
                ", uvIndex='" + uvIndex + '\'' +
                ", uvIndexTime='" + uvIndexTime + '\'' +
                ", visibility='" + visibility + '\'' +
                ", dewPoint='" + dewPoint + '\'' +
                ", humidity='" + humidity + '\'' +
                ", pressure='" + pressure + '\'' +
                ", cloudCover='" + cloudCover + '\'' +
                ", ozone='" + ozone + '\'' +
                '}';
    }
    
    public static class Builder {
        private String time;
        private String summary;
        private String icon;
        private String sunriseTime;
        private String sunsetTime;
        private String moonPhase;
        private String nearestStormBearing;
        private String nearestStormDistance;
        private String precipIntensity;
        private String precipIntensityError;
        private String precipIntensityMax;
        private String precipIntensityMaxTime;
        private String precipProbability;
        private String precipAccumulation;
        private String precipType;
        private String temperature;
        private String temperatureHigh;
        private String temperatureHighTime;
        private String temperatureLow;
        private String temperatureLowTime;
        private String apparentTemperature;
        private String apparentTemperatureHigh;
        private String apparentTemperatureHighTime;
        private String apparentTemperatureLow;
        private String apparentTemperatureLowTime;
        private String windSpeed;
        private String windGust;
        private String windGustTime;
        private String windBearing;
        private String uvIndex;
        private String uvIndexTime;
        private String visibility;
        private String dewPoint;
        private String humidity;
        private String pressure;
        private String cloudCover;
        private String ozone;
        
        public Builder time(String time) {
            this.time = time;
            return this;
        }
        
        public Builder summary(String summary) {
            this.summary = summary;
            return this;
        }
        
        public Builder icon(String icon) {
            this.icon = icon;
            return this;
        }
        
        public Builder sunriseTime(String sunriseTime) {
            this.sunriseTime = sunriseTime;
            return this;
        }
        
        public Builder sunsetTime(String sunsetTime) {
            this.sunsetTime = sunsetTime;
            return this;
        }
        
        public Builder moonPhase(String moonPhase) {
            this.moonPhase = moonPhase;
            return this;
        }
        
        public Builder nearestStormBearing(String nearestStormBearing) {
            this.nearestStormBearing = nearestStormBearing;
            return this;
        }
        
        public Builder nearestStormDistance(String nearestStormDistance) {
            this.nearestStormDistance = nearestStormDistance;
            return this;
        }
        
        public Builder precipIntensity(String precipIntensity) {
            this.precipIntensity = precipIntensity;
            return this;
        }
        
        public Builder precipIntensityError(String precipIntensityError) {
            this.precipIntensityError = precipIntensityError;
            return this;
        }
        
        public Builder precipIntensityMax(String precipIntensityMax) {
            this.precipIntensityMax = precipIntensityMax;
            return this;
        }
        
        public Builder precipIntensityMaxTime(String precipIntensityMaxTime) {
            this.precipIntensityMaxTime = precipIntensityMaxTime;
            return this;
        }
        
        public Builder precipProbability(String precipProbability) {
            this.precipProbability = precipProbability;
            return this;
        }
        
        public Builder precipAccumulation(String precipAccumulation) {
            this.precipAccumulation = precipAccumulation;
            return this;
        }
        
        public Builder precipType(String precipType) {
            this.precipType = precipType;
            return this;
        }
        
        public Builder temperature(String temperature) {
            this.temperature = temperature;
            return this;
        }
        
        public Builder temperatureHigh(String temperatureHigh) {
            this.temperatureHigh = temperatureHigh;
            return this;
        }
        
        public Builder temperatureHighTime(String temperatureHighTime) {
            this.temperatureHighTime = temperatureHighTime;
            return this;
        }
        
        public Builder temperatureLow(String temperatureLow) {
            this.temperatureLow = temperatureLow;
            return this;
        }
        
        public Builder temperatureLowTime(String temperatureLowTime) {
            this.temperatureLowTime = temperatureLowTime;
            return this;
        }
        
        public Builder apparentTemperature(String apparentTemperature) {
            this.apparentTemperature = apparentTemperature;
            return this;
        }
        
        public Builder apparentTemperatureHigh(String apparentTemperatureHigh) {
            this.apparentTemperatureHigh = apparentTemperatureHigh;
            return this;
        }
        
        public Builder apparentTemperatureHighTime(String apparentTemperatureHighTime) {
            this.apparentTemperatureHighTime = apparentTemperatureHighTime;
            return this;
        }
        
        public Builder apparentTemperatureLow(String apparentTemperatureLow) {
            this.apparentTemperatureLow = apparentTemperatureLow;
            return this;
        }
        
        public Builder apparentTemperatureLowTime(String apparentTemperatureLowTime) {
            this.apparentTemperatureLowTime = apparentTemperatureLowTime;
            return this;
        }
        
        public Builder windSpeed(String windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }
        
        public Builder windGust(String windGust) {
            this.windGust = windGust;
            return this;
        }
        
        public Builder windGustTime(String windGustTime) {
            this.windGustTime = windGustTime;
            return this;
        }
        
        public Builder windBearing(String windBearing) {
            this.windBearing = windBearing;
            return this;
        }
        
        public Builder uvIndex(String uvIndex) {
            this.uvIndex = uvIndex;
            return this;
        }
        
        public Builder uvIndexTime(String uvIndexTime) {
            this.uvIndexTime = uvIndexTime;
            return this;
        }
        
        public Builder visibility(String visibility) {
            this.visibility = visibility;
            return this;
        }
        
        public Builder dewPoint(String dewPoint) {
            this.dewPoint = dewPoint;
            return this;
        }
        
        public Builder humidity(String humidity) {
            this.humidity = humidity;
            return this;
        }
        
        public Builder pressure(String pressure) {
            this.pressure = pressure;
            return this;
        }
        
        public Builder cloudCover(String cloudCover) {
            this.cloudCover = cloudCover;
            return this;
        }
        
        public Builder ozone(String ozone) {
            this.ozone = ozone;
            return this;
        }
        
        public WeatherData build() {
            return new WeatherData(time, summary, icon,
                    sunriseTime, sunsetTime, moonPhase,
                    nearestStormBearing, nearestStormDistance,
                    precipIntensity, precipIntensityError,
                    precipIntensityMax, precipIntensityMaxTime,
                    precipProbability, precipAccumulation, precipType,
                    temperature, temperatureHigh, temperatureHighTime,
                    temperatureLow, temperatureLowTime,
                    apparentTemperature,
                    apparentTemperatureHigh, apparentTemperatureHighTime,
                    apparentTemperatureLow, apparentTemperatureLowTime,
                    windSpeed, windGust, windGustTime, windBearing,
                    uvIndex, uvIndexTime,
                    visibility, dewPoint, humidity, pressure,
                    cloudCover, ozone);
        }
    }
}
