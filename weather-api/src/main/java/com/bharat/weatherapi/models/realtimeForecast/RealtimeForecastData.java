package com.bharat.weatherapi.models.realtimeForecast;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.bharat.weatherapi.models.wrapper.hourlyForecast.ForecastData;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class RealtimeForecastData {
    private String time;
    private ForecastData values;
}
