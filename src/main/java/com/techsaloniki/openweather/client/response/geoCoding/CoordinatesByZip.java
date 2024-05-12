package com.techsaloniki.openweather.client.response.geoCoding;

public class CoordinatesByZip extends OpenWeatherGeoCodeApiCoreResponse{

    private String zip;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
