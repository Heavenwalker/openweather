package com.techsaloniki.openweather;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithName;

@ConfigMapping(prefix = "openweather")
public interface OpenWeatherConfig {

    @WithName("api-key")
    @WithDefault("YOUR_API_KEY")
    String apiKey();
}
