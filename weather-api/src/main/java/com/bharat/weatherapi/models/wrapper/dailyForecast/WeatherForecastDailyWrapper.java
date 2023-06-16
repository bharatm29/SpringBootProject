package com.bharat.weatherapi.models.wrapper.dailyForecast;

import com.bharat.weatherapi.models.LocationData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class WeatherForecastDailyWrapper {
    private LocationData location;
    private DailyTimelines timelines;
}
