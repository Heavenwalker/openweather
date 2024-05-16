package com.techsaloniki.openweather.client.request.weatherData;

import com.techsaloniki.openweather.client.request.OpenWeatherApiCoreRequestParam;
import jakarta.ws.rs.QueryParam;

public class GetWeatherInfoBeanParam extends OpenWeatherApiCoreRequestParam {

    @QueryParam("lat")
    private String lat;
    @QueryParam("lon")
    private String lon;
    @QueryParam("mode")
    private String mode;
    @QueryParam("units")
    private String units;
    @QueryParam("lang")
    private String lang;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }


    public static final class Builder {
        private String lat;
        private String lon;
        private String mode;
        private String units;
        private String lang;
        private String appId;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder lat(String lat) {
            this.lat = lat;
            return this;
        }

        public Builder lon(String lon) {
            this.lon = lon;
            return this;
        }

        public Builder mode(String mode) {
            this.mode = mode;
            return this;
        }

        public Builder units(String units) {
            this.units = units;
            return this;
        }

        public Builder lang(String lang) {
            this.lang = lang;
            return this;
        }

        public Builder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public GetWeatherInfoBeanParam build() {
            GetWeatherInfoBeanParam getWeatherInfoBeanParam = new GetWeatherInfoBeanParam();
            getWeatherInfoBeanParam.setLat(lat);
            getWeatherInfoBeanParam.setLon(lon);
            getWeatherInfoBeanParam.setMode(mode);
            getWeatherInfoBeanParam.setUnits(units);
            getWeatherInfoBeanParam.setLang(lang);
            getWeatherInfoBeanParam.setAppId(appId);
            return getWeatherInfoBeanParam;
        }
    }
}
