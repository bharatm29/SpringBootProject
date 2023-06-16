package com.bharat.weatherapi.models.realtimeForecast;

import com.bharat.weatherapi.models.LocationData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class RealtimeForecast {
    private LocationData location;
    private RealtimeForecastData data;
}
