package com.bharat.weatherapi.models.wrapper.hourlyForecast;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class HourlyForecast {
    private String time;
    private ForecastData values;
}
