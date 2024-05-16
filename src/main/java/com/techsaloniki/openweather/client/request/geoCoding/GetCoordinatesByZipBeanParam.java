package com.techsaloniki.openweather.client.request.geoCoding;

import com.techsaloniki.openweather.client.request.OpenWeatherApiCoreRequestParam;
import jakarta.ws.rs.QueryParam;

public class GetCoordinatesByZipBeanParam extends OpenWeatherApiCoreRequestParam {

    @QueryParam("zip")
    private String zip;


    public static final class Builder {
        private String zip;
        private String appId;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder zip(String zip) {
            this.zip = zip;
            return this;
        }

        public Builder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public GetCoordinatesByZipBeanParam build() {
            GetCoordinatesByZipBeanParam getCoordinatesByZipBeanParam = new GetCoordinatesByZipBeanParam();
            getCoordinatesByZipBeanParam.setAppId(appId);
            getCoordinatesByZipBeanParam.zip = this.zip;
            return getCoordinatesByZipBeanParam;
        }
    }
}
