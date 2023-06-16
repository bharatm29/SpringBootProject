package com.bharat.weatherapi.services;

import com.bharat.weatherapi.models.DateHandler;
import com.bharat.weatherapi.models.WeatherCodes;
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

    public WeatherForecastHourly getWeatherForecastHourly(String location, Integer page) {
        String url = forecastUrl + "?location=" + location + "&apikey=" + apiKey + "&timesteps=1h";

        WeatherForecastHourlyWrapper hourlyRes =  restTemplate.getForObject(url, WeatherForecastHourlyWrapper.class);

        return weatherForecastHourly.makeObjectFromWrapper(hourlyRes, page);
    }
    public WeatherForecastDaily getWeatherForecastDaily(String location) {
        String url = forecastUrl + "?location=" + location + "&apikey=" + apiKey + "&timesteps=1d";

        WeatherForecastDailyWrapper dailyRes = restTemplate.getForObject(url, WeatherForecastDailyWrapper.class);

        return weatherForecastDaily.makeObjectFromWrapper(dailyRes);
    }
}
