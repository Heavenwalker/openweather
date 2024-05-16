package com.techsaloniki.openweather.service;


import com.techsaloniki.openweather.client.OpenWeatherClient;
import com.techsaloniki.openweather.OpenWeatherConfig;
import com.techsaloniki.openweather.client.request.geoCoding.GetCoordinatesByCityNameBeanParam;
import com.techsaloniki.openweather.client.request.weatherData.GetWeatherInfoBeanParam;
import com.techsaloniki.openweather.client.response.geoCoding.CoordinatesByCityName;
import com.techsaloniki.openweather.client.response.weatherData.OpenWeatherResponse;
import com.techsaloniki.openweather.resource.FindByCityParamWrapper;
import io.quarkus.cache.CacheResult;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OpenWeatherService {

    final OpenWeatherClient openWeatherClient;
    final OpenWeatherConfig openWeatherConfig;

    @Inject
    public OpenWeatherService(@RestClient OpenWeatherClient openWeatherClient, OpenWeatherConfig openWeatherConfig) {
        this.openWeatherClient = openWeatherClient;
        this.openWeatherConfig = openWeatherConfig;
    }

@CacheResult(cacheName = "weather-cache")
    public OpenWeatherResponse getWeatherByCity(FindByCityParamWrapper findByCityParamWrapper) {
        var city = findByCityParamWrapper.getCity();
        var state = findByCityParamWrapper.getState();
        var country = findByCityParamWrapper.getCountry();
        var units = findByCityParamWrapper.getUnits() == null ? "metric" : findByCityParamWrapper.getUnits();

        var coords = retrieveCoordinates(city, state, country);

        return Optional.ofNullable(coords)
                .filter(c -> !c.isEmpty())
                .map(c -> c.get(0))
                .map(c -> GetWeatherInfoBeanParam.Builder.builder()
                        .lat(String.valueOf(c.getLat()))
                        .lon(String.valueOf(c.getLon()))
                        .units(units)
                        .appId(openWeatherConfig.apiKey())
                        .build())
                .map(openWeatherClient::getWeatherInfo)
                .orElseThrow(() -> new BadRequestException("No coordinates found for city"));
    }

    private List<CoordinatesByCityName> retrieveCoordinates(String city, String state, String country) {
        var q = buildLocationString(city, state, country);
        var getCoordinatesByCityNameBeanParam = GetCoordinatesByCityNameBeanParam.Builder.builder()
                .locationInfo(q)
                .appId(openWeatherConfig.apiKey())
                .build();
        Log.info("Calling OpenWeather API with query: " + q);
        return openWeatherClient.getCoordinatesByCityName(getCoordinatesByCityNameBeanParam);
    }

    public String getWeatherByZip(String zip, String country) {
        return "Weather by zip";
    }

    private String buildLocationString(String city, String state, String country) {
        StringBuilder sb = new StringBuilder(city); // City is always present

        // Append state if it is not null and not empty
        if (state != null && !state.isEmpty()) {
            sb.append(", ").append(state);
        }

        // Append country if it is not null and not empty
        if (country != null && !country.isEmpty()) {
            sb.append(", ").append(country);
        }

        return sb.toString();
    }
}
