package com.bharat.weatherapi.models.wrapper.dailyForecast;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class DailyForecast{
    private String time;
    private DailyForecastData values;
}
