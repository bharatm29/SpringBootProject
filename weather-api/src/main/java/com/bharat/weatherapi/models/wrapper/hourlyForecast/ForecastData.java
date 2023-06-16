package com.bharat.weatherapi.models.wrapper.hourlyForecast;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class ForecastData {
    private String freezingRainIntensity, humidity, iceAccumulation, iceAccumulationLwe, precipitationProbability,
                pressureSurfaceLevel, rainAccumulation, rainIntensity, snowAccumulation,
                snowIntensity, temperature, weatherCode, windDirection, windGust, windSpeed;
}
