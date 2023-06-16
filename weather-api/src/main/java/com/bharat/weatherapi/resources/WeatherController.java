package com.bharat.weatherapi.resources;

import com.bharat.weatherapi.models.WeatherCodes;
import com.bharat.weatherapi.models.WeatherForecastDaily;
import com.bharat.weatherapi.models.WeatherForecastHourly;
import com.bharat.weatherapi.models.realtimeForecast.RealtimeForecast;
import com.bharat.weatherapi.services.WeatherService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherCodes weatherCodes;

    @GetMapping("/realtime/{location}")
    public RealtimeForecast getRealtimeWeather(@PathVariable String location){
        return weatherService.getRealtimeWeather(location);
    }

    @GetMapping("/forecast/daily/{location}")
    public WeatherForecastDaily getWeatherForecastDaily(
            @PathVariable String location
    ){
        return weatherService.getWeatherForecastDaily(location);
    }
    @GetMapping("/forecast/hourly/{location}")
    public WeatherForecastHourly getWeatherForecast(
            @PathVariable String location,
            @RequestParam(required = false, value = "page", defaultValue = "1") Integer page
    ){
        return weatherService.getWeatherForecastHourly(location, page);
    }
}
