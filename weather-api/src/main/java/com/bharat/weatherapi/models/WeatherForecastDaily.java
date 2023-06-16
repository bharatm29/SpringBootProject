package com.bharat.weatherapi.models;

import com.bharat.weatherapi.models.wrapper.dailyForecast.DailyForecast;
import com.bharat.weatherapi.models.wrapper.dailyForecast.WeatherForecastDailyWrapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Component
public class WeatherForecastDaily{
    private LocationData location;
    private List<DailyForecast> data;

    @Autowired
    @JsonIgnore //this will ignore this field from being serialized during a response!
    private WeatherCodes weatherCodes;

    public WeatherForecastDaily makeObjectFromWrapper(WeatherForecastDailyWrapper wrapper){
        if(wrapper == null){
            return WeatherForecastDaily.builder()
                    .location(LocationData.builder().name("No such location found!").build())
                    .data(List.of(DailyForecast.builder().time("0").build()))
                    .build();
        }

        Map<String, String> codes = weatherCodes.getCodes();
        List<DailyForecast> dailyData = wrapper.getTimelines().getDaily();

        dailyData.forEach(data -> {
                    data.setTime(DateHandler.getFormatDate(data.getTime()));
                    var val = data.getValues();
                    val.setWeatherCodeMax(codes.get(val.getWeatherCodeMax()));
                    val.setWeatherCodeMin(codes.get(val.getWeatherCodeMin()));
                });

        return WeatherForecastDaily.builder()
                .location(wrapper.getLocation())
                .data(dailyData)
                .build();
    }
}
