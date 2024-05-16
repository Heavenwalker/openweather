package com.techsaloniki.openweather.client;

import com.techsaloniki.openweather.client.request.geoCoding.GetCoordinatesByCityNameBeanParam;
import com.techsaloniki.openweather.client.request.geoCoding.GetCoordinatesByZipBeanParam;
import com.techsaloniki.openweather.client.request.weatherData.GetWeatherInfoBeanParam;
import com.techsaloniki.openweather.client.response.geoCoding.CoordinatesByCityName;
import com.techsaloniki.openweather.client.response.geoCoding.CoordinatesByZip;
import com.techsaloniki.openweather.client.response.weatherData.OpenWeatherResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(configKey="openweather")
public interface OpenWeatherClient {

    @GET
    @Path("/geo/1.0/direct")
    List<CoordinatesByCityName> getCoordinatesByCityName(GetCoordinatesByCityNameBeanParam queryParams);

    @GET
    @Path("/geo/1.0/zip")
    List<CoordinatesByZip> getCoordinatesByZip(GetCoordinatesByZipBeanParam queryParams);

    @GET
    @Path("data/2.5/weather")
    OpenWeatherResponse getWeatherInfo(GetWeatherInfoBeanParam queryParams);

}
