package com.space.SpaceAPI.resource;

import com.space.SpaceAPI.models.AstroPicture;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/space")
public class SpaceController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${apod.url}")
    private String apodUrl;

    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/apod/{date}")
    @CircuitBreaker(name = "apodCB", fallbackMethod = "apodFallBack")
    public @ResponseBody AstroPicture getAPOD(@PathVariable String date){
        return restTemplate.getForObject(apodUrl + apiKey + "&date=" + date,
                                        AstroPicture.class);
    }

    public AstroPicture apodFallBack(String date, Exception e){
        return new AstroPicture("No image found", "null", date, "Server failed to retrieve the image");
    }
}
