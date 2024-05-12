package com.techsaloniki.openweather.resource;

import com.techsaloniki.openweather.client.response.weatherData.OpenWeatherResponse;
import com.techsaloniki.openweather.service.OpenWeatherService;
import jakarta.inject.Inject;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/openweather")
public class OpenWeatherResource {

    final OpenWeatherService openWeatherService;

    @Inject
    public OpenWeatherResource(OpenWeatherService openWeatherService) {
        this.openWeatherService = openWeatherService;
    }

    @GET
    @Path("/byCity/")
    public OpenWeatherResponse getWeatherByCity(@NotBlank @QueryParam("city") String city,
                                                @QueryParam("state") String state,
                                                @QueryParam("country") String country){
        return openWeatherService.getWeatherByCity(city, state, country);
    }

    @GET
    @Path("/byZip/")
    public String getWeatherByZip(@QueryParam("zip") String zip,
                                  @QueryParam("country") String country) {
        return "Weather by zip";
    }
}
