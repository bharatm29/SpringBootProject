package com.bharat.weatherapi.models;

import com.bharat.weatherapi.models.wrapper.hourlyForecast.HourlyForecast;
import com.bharat.weatherapi.models.wrapper.hourlyForecast.WeatherForecastHourlyWrapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class WeatherForecastHourly {
    private LocationData location;
    private List<HourlyForecast> data;

    public static WeatherForecastHourly makeObjectFromWrapper(WeatherForecastHourlyWrapper wrapper){
        if(wrapper == null){
            return WeatherForecastHourly.builder()
                    .location(LocationData.builder().name("No such location found!").build())
                    .data(List.of(HourlyForecast.builder().time("0").build()))
                    .build();
        }
        return WeatherForecastHourly.builder()
                .location(wrapper.getLocation())
                .data(wrapper.getTimelines().getHourly())
                .build();
    }
}
