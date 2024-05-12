package com.techsaloniki.openweather.client.request;

import jakarta.ws.rs.QueryParam;

public class OpenWeatherApiCoreRequestParam {

    @QueryParam("appid")
    private String appId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

}
