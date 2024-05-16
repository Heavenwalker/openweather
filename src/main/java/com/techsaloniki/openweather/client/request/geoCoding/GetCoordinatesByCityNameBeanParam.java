package com.techsaloniki.openweather.client.request.geoCoding;

import com.techsaloniki.openweather.client.request.OpenWeatherApiCoreRequestParam;
import jakarta.ws.rs.QueryParam;

public class GetCoordinatesByCityNameBeanParam extends OpenWeatherApiCoreRequestParam {

    @QueryParam("q")
    String locationInfo;

    public String getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(String locationInfo) {
        this.locationInfo = locationInfo;
    }


    public static final class Builder {
        private String locationInfo;
        private String appId;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder locationInfo(String cityName) {
            this.locationInfo = cityName;
            return this;
        }

        public Builder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public GetCoordinatesByCityNameBeanParam build() {
            GetCoordinatesByCityNameBeanParam getCoordinatesByCityNameBeanParam = new GetCoordinatesByCityNameBeanParam();
            getCoordinatesByCityNameBeanParam.setLocationInfo(locationInfo);
            getCoordinatesByCityNameBeanParam.setAppId(appId);
            return getCoordinatesByCityNameBeanParam;
        }
    }
}
