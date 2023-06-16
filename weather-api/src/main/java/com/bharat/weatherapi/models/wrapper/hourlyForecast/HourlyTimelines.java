package com.bharat.weatherapi.models.wrapper.hourlyForecast;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class HourlyTimelines {
    private List<HourlyForecast> hourly;
}
