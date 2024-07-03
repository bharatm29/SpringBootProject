package com.space.SpaceAPI.resource;

import com.space.SpaceAPI.models.AstroAPODPicture;
import com.space.SpaceAPI.models.astroImage.AstroImage;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class AstroAPI {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${apod.url}")
    private String apodUrl;

    @Value("${api.key}")
    private String apiKey;

    @Value("${image.url}")
    private String imageUrl;

    @CircuitBreaker(name = "apodCB", fallbackMethod = "apodFallBack")
    public AstroAPODPicture getAPOD(String date){
        return restTemplate.getForObject(apodUrl + apiKey + "&date=" + date,
                AstroAPODPicture.class);
    }

    @CircuitBreaker(name = "imageCB", fallbackMethod = "imageFallBack")
    public AstroImage getImage(String search, String page){
        return restTemplate.getForObject(imageUrl + search + "&page=" + page, AstroImage.class);
    }

    public AstroAPODPicture apodFallBack(String date, Exception e){
        String errorExplanation = "Server failed to retrieve the image or no APOD found for the date";
        return new AstroAPODPicture("No image found", "null", date, errorExplanation);
    }

    public AstroImage imageFallBack(String search, String page, Exception e){
        return AstroImage.getDefaultImage();
    }
}
