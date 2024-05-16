package com.techsaloniki.openweather.client.response.geoCoding;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherGeoCodeApiCoreResponse {

    @JsonProperty("name")
    private String name;
    @JsonProperty("lat")
    private Float lat;
    @JsonProperty("lon")
    private Float lon;
    @JsonProperty("country")
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
