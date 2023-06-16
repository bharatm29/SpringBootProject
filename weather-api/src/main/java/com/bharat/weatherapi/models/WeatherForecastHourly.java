package com.bharat.weatherapi.models;

import com.bharat.weatherapi.models.wrapper.dailyForecast.DailyForecast;
import com.bharat.weatherapi.models.wrapper.hourlyForecast.ForecastData;
import com.bharat.weatherapi.models.wrapper.hourlyForecast.HourlyForecast;
import com.bharat.weatherapi.models.wrapper.hourlyForecast.WeatherForecastHourlyWrapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Component
public class WeatherForecastHourly {
    private LocationData location;
    private List<HourlyForecast> data;

    @Autowired
    @JsonIgnore
    private WeatherCodes weatherCodes;

    public WeatherForecastHourly makeObjectFromWrapper(WeatherForecastHourlyWrapper wrapper, Integer page){
        if(wrapper == null){
            return WeatherForecastHourly.builder()
                    .location(LocationData.builder().name("No such location found!").build())
                    .data(List.of(HourlyForecast.builder().time("0").build()))
                    .build();
        }
        List<HourlyForecast> hourlyData = wrapper.getTimelines().getHourly()
                .stream()
                .limit(page * 10)
                .toList();

        hourlyData.forEach(value -> {
            var val = value.getValues();
            val.setWeatherCode(weatherCodes.getCodes().get(val.getWeatherCode()));
        });

        return WeatherForecastHourly.builder()
                .location(wrapper.getLocation())
                .data(hourlyData)
                .build();
    }
}
