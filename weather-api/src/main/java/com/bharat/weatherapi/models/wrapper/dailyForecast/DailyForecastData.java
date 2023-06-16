package com.bharat.weatherapi.models.wrapper.dailyForecast;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class DailyForecastData {
    private String 
            freezingRainIntensityAvg,
            humidityAvg,
            iceAccumulationAvg,
            moonriseTime,
            moonsetTime,
            precipitationProbabilityAvg,
            pressureSurfaceLevelAvg,
            rainAccumulationAvg,
            rainIntensityAvg,
            rainIntensityMax,
            sleetAccumulationAvg,
            sleetIntensityAvg,
            snowAccumulationAvg,
            snowIntensityAvg,
            sunriseTime,
            sunsetTime,
            temperatureAvg,
            temperatureMax,
            temperatureMin,
            visibilityAvg,
            weatherCodeMax,
            weatherCodeMin,
            windDirectionAvg,
            windGustAvg,
            windSpeedAvg,
            windSpeedMax;
}
