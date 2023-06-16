package com.bharat.weatherapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/realtime/{location}")
    public WeatherRealtime getRealtimeWeather(@PathVariable String location){
        return weatherService.getRealtimeWeather(location);
    }

    @GetMapping("/forecast/{location}")
    public WeatherForecast getWeatherForecast(
            @PathVariable String location,
            @RequestParam(required = false, value = "page", defaultValue = "1") String page,
            @RequestParam(required = false, value = "timesteps", defaultValue = "1d") String timesteps,
            @RequestParam(required = false, value = "size", defaultValue = "5") String pageSize
    ){
        return weatherService.getWeatherForecast(location, page, timesteps, pageSize);
    }
}
