package com.bharat.weatherapi.models.wrapper.hourlyForecast;

import com.bharat.weatherapi.models.LocationData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherForecastHourlyWrapper {
    private LocationData location;
    private HourlyTimelines timelines;
}
