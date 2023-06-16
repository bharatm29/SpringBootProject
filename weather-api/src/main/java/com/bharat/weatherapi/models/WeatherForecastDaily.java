package com.bharat.weatherapi.models;

import com.bharat.weatherapi.models.wrapper.dailyForecast.DailyForecast;
import com.bharat.weatherapi.models.wrapper.dailyForecast.WeatherForecastDailyWrapper;
import com.bharat.weatherapi.models.wrapper.hourlyForecast.HourlyForecast;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class WeatherForecastDaily{
    private LocationData location;
    private List<DailyForecast> data;

    public static WeatherForecastDaily makeObjectFromWrapper(WeatherForecastDailyWrapper wrapper){
        if(wrapper == null){
            return WeatherForecastDaily.builder()
                    .location(LocationData.builder().name("No such location found!").build())
                    .data(List.of(DailyForecast.builder().time("0").build()))
                    .build();
        }
        return WeatherForecastDaily.builder()
                .location(wrapper.getLocation())
                .data(wrapper.getTimelines().getDaily())
                .build();
    }
}
