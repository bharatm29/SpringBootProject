package com.bharat.weatherapi.services;

import com.bharat.weatherapi.models.*;
import com.bharat.weatherapi.models.realtimeForecast.RealtimeForecastData;
import com.bharat.weatherapi.models.wrapper.dailyForecast.DailyForecast;
import com.bharat.weatherapi.models.wrapper.dailyForecast.DailyForecastData;
import com.bharat.weatherapi.models.wrapper.dailyForecast.WeatherForecastDailyWrapper;
import com.bharat.weatherapi.models.realtimeForecast.RealtimeForecast;
import com.bharat.weatherapi.models.wrapper.hourlyForecast.ForecastData;
import com.bharat.weatherapi.models.wrapper.hourlyForecast.HourlyForecast;
import com.bharat.weatherapi.models.wrapper.hourlyForecast.WeatherForecastHourlyWrapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @Value("${url.forecast}")
    private String forecastUrl;

    @Value("${url.realtime}")
    private String realtimeUrl;

    @Autowired
    private WeatherForecastDaily weatherForecastDaily;

    @Autowired
    private WeatherForecastHourly weatherForecastHourly;

    @Autowired
    private WeatherCodes weatherCodes;

    @CircuitBreaker(name = "realtime-cb", fallbackMethod = "getRealtimeFallback")
    public RealtimeForecast getRealtimeWeather(String location) {
        String url = realtimeUrl + "?location=" + location + "&apikey=" + apiKey;

        RealtimeForecast realtimeForecast = restTemplate.getForObject(url, RealtimeForecast.class);

        if(realtimeForecast != null){
            realtimeForecast.getData().setTime(DateHandler.getFormatDate(realtimeForecast.getData().getTime()));
            var values = realtimeForecast.getData().getValues();
            values.setWeatherCode(weatherCodes.getCodes().get(values.getWeatherCode()));
        }

        return realtimeForecast;
    }

    @CircuitBreaker(name = "hourly-cb", fallbackMethod = "getHourlyForecastFallback")
    public WeatherForecastHourly getWeatherForecastHourly(String location, Integer page) {
        String url = forecastUrl + "?location=" + location + "&apikey=" + apiKey + "&timesteps=1h";

        WeatherForecastHourlyWrapper hourlyRes =  restTemplate.getForObject(url, WeatherForecastHourlyWrapper.class);

        return weatherForecastHourly.makeObjectFromWrapper(hourlyRes, page);
    }

    @CircuitBreaker(name = "daily-cb", fallbackMethod = "getDailyForecastFallback")
    public WeatherForecastDaily getWeatherForecastDaily(String location) {
        String url = forecastUrl + "?location=" + location + "&apikey=" + apiKey + "&timesteps=1d";

        WeatherForecastDailyWrapper dailyRes = restTemplate.getForObject(url, WeatherForecastDailyWrapper.class);

        return weatherForecastDaily.makeObjectFromWrapper(dailyRes);
    }

    public RealtimeForecast getRealtimeFallback(String location, Exception e){
        if(e.getMessage().contains("429")){
            return RealtimeForecast.builder()
                    .location(LocationData.builder().name("Too many requests").build())
                    .data(RealtimeForecastData.builder()
                            .time("No data found for the location")
                            .values(ForecastData.builder().weatherCode("0").build())
                            .build())
                    .build();
        }
        return RealtimeForecast.builder()
                .location(LocationData.builder().name("Location not found").build())
                .data(RealtimeForecastData.builder().time("No data found for the location").build())
                .build();
    }
    public WeatherForecastHourly getHourlyForecastFallback(String location, Integer page, Exception e){
        if(e.getMessage().contains("429")){
            return WeatherForecastHourly.builder()
                    .location(LocationData.builder().name("Too many requests").build())
                    .data(List.of(HourlyForecast.builder()
                            .time("No data found for the location")
                            .values(ForecastData.builder().weatherCode("0").build())
                            .build()))
                    .build();
        }
        return WeatherForecastHourly.builder()
                .location(LocationData.builder().name("Location not found").build())
                .data(List.of(HourlyForecast.builder().time("No data found for the location").build()))
                .build();
    }
    public WeatherForecastDaily getDailyForecastFallback(String location, Exception e){
        if(e.getMessage().contains("429")){
            return WeatherForecastDaily.builder()
                    .location(LocationData.builder().name("Too many requests").build())
                    .data(List.of(DailyForecast.builder()
                            .time("No data found for the location")
                            .values(DailyForecastData.builder().weatherCodeMax("0").build())
                            .build()))
                    .build();
        }
        return WeatherForecastDaily.builder()
                .location(LocationData.builder().name("Location not found").build())
                .data(List.of(DailyForecast.builder().time("No data found for the location").build()))
                .build();
    }
}
