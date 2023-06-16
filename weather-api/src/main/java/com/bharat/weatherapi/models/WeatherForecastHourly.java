package com.bharat.weatherapi.models;

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
        page = page > 12 ? 12 : page;
        long skip = (long) (page == 1 ? 0 : (page - 1) * 10L);
        List<HourlyForecast> hourlyData = wrapper.getTimelines().getHourly()
                .stream()
                .skip(skip)
                .limit(10)
                .toList();

        hourlyData.forEach(data -> {
            data.setTime(DateHandler.getFormatDate(data.getTime()));
            var val = data.getValues();
            val.setWeatherCode(weatherCodes.getCodes().get(val.getWeatherCode()));
        });

        return WeatherForecastHourly.builder()
                .location(wrapper.getLocation())
                .data(hourlyData)
                .build();
    }
}
