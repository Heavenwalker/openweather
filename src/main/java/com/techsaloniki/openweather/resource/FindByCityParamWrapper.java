package com.techsaloniki.openweather.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.QueryParam;

public class FindByCityParamWrapper{

    @NotBlank
    @QueryParam("city")
    String city;
    @QueryParam("state")
    String state;
    @QueryParam("country")
    String country;
    @QueryParam("units")
    String units;

    public @NotBlank String getCity() {
        return city;
    }

    public void setCity(@NotBlank String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}