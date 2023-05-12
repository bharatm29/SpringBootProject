package com.space.SpaceAPI.resource;

import com.space.SpaceAPI.models.AstroAPODPicture;
import com.space.SpaceAPI.models.astroImage.AstroImage;
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

    @Value("${image.url}")
    private String imageUrl;

    @GetMapping("/apod/{date}")
    @CircuitBreaker(name = "apodCB", fallbackMethod = "apodFallBack")
    public @ResponseBody AstroAPODPicture getAPOD(@PathVariable String date){
        return restTemplate.getForObject(apodUrl + apiKey + "&date=" + date,
                                        AstroAPODPicture.class);
    }

    @GetMapping("/images/{search}")
    public @ResponseBody AstroImage getSearchImages(@PathVariable String search){
        return restTemplate.getForObject(imageUrl + search, AstroImage.class);aaaaaaaaaaa
    }

    public AstroAPODPicture apodFallBack(String date, Exception e){
        String errorExplanation = "Server failed to retrieve the image or no APOD found for the date";
        return new AstroAPODPicture("No image found", "null", date, errorExplanation);
    }
}
