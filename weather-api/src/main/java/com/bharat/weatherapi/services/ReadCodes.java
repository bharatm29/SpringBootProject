package com.bharat.weatherapi.services;

import com.bharat.weatherapi.models.WeatherCodes;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class ReadCodes {
    @Value("classpath:weatherCodes.json")
    private Resource jsonFile;

    @Bean
    public WeatherCodes getCodes() throws IOException {
        final String codeString = jsonFile.getContentAsString(StandardCharsets.UTF_8);

        ObjectMapper jsonMapper = new ObjectMapper();
        WeatherCodes weatherCodes = jsonMapper.readValue(codeString, WeatherCodes.class);

        return weatherCodes;
    }
}
