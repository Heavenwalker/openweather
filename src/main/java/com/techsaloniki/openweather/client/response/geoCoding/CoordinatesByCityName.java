package com.techsaloniki.openweather.client.response.geoCoding;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class CoordinatesByCityName extends OpenWeatherGeoCodeApiCoreResponse {

    @JsonProperty("local_names")
    private Map<String, String> localNames;
    @JsonProperty("state")
    private String state;

    public Map<String, String> getLocalNames() {
        return localNames;
    }

    public void setLocalNames(Map<String, String> localNames) {
        this.localNames = localNames;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
