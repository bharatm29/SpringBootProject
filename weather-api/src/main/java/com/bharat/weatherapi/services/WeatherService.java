package com.bharat.weatherapi.services;

import com.bharat.weatherapi.models.WeatherForecastDaily;
import com.bharat.weatherapi.models.wrapper.dailyForecast.WeatherForecastDailyWrapper;
import com.bharat.weatherapi.models.WeatherForecastHourly;
import com.bharat.weatherapi.models.realtimeForecast.RealtimeForecast;
import com.bharat.weatherapi.models.wrapper.hourlyForecast.WeatherForecastHourlyWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Autowired
    private RestTemplate restTemplate;

//    @Value("${api.key}")
//    private String apiKey;

    @Value("${url.forecast}")
    private String forecastUrl;

    @Value("${url.realtime}")
    private String realtimeUrl;

    public RealtimeForecast getRealtimeWeather(String location) {
        String url = realtimeUrl + "?location=" + location + "&apikey=YEGsCPSIbbeZrG6esvVheZUwrwl0TxIf";
        return restTemplate.getForObject(url, RealtimeForecast.class);
    }

    public WeatherForecastHourly getWeatherForecastHourly(String location, String page, String pageSize) {
        String url = forecastUrl + "?location=" + location + "&apikey=YEGsCPSIbbeZrG6esvVheZUwrwl0TxIf" + "&timesteps=1h";
        WeatherForecastHourlyWrapper hourlyRes =  restTemplate.getForObject(url, WeatherForecastHourlyWrapper.class);
        return WeatherForecastHourly.makeObjectFromWrapper(hourlyRes);
    }
    public WeatherForecastDaily getWeatherForecastDaily(String location, String page, String pageSize) {
        String url = forecastUrl + "?location=" + location + "&apikey=YEGsCPSIbbeZrG6esvVheZUwrwl0TxIf" + "&timesteps=1d";
        WeatherForecastDailyWrapper dailyRes = restTemplate.getForObject(url, WeatherForecastDailyWrapper.class);
        return WeatherForecastDaily.makeObjectFromWrapper(dailyRes);
    }
}
