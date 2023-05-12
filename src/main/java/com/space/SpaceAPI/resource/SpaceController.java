package com.space.SpaceAPI.resource;

import com.space.SpaceAPI.models.AstroAPODPicture;
import com.space.SpaceAPI.models.astroImage.AstroImage;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Get the Astronomy Picture of the Day for a day",
                responses = {
                    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"),
                                description = "Found the picture"),
                    @ApiResponse(responseCode = "404", description = "Could not found the picture - Check date format")
                })
    @GetMapping("/apod/{date}")
    @CircuitBreaker(name = "apodCB", fallbackMethod = "apodFallBack")
    public @ResponseBody AstroAPODPicture getAPOD(@PathVariable String date){
        return restTemplate.getForObject(apodUrl + apiKey + "&date=" + date,
                                        AstroAPODPicture.class);
    }

    @Operation(summary = "Search image from NASA repository",
                responses = {
                    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"),
                                    description = "Found the images"),
                    @ApiResponse(responseCode = "404", description = "Could not find the images with the keyword")
                })
    @GetMapping("/images/{search}")
    @CircuitBreaker(name = "imageCB", fallbackMethod = "imageFallBack")
    public @ResponseBody AstroImage getSearchImages(@PathVariable String search){
        return restTemplate.getForObject(imageUrl + search, AstroImage.class);
    }

    public AstroAPODPicture apodFallBack(String date, Exception e){
        String errorExplanation = "Server failed to retrieve the image or no APOD found for the date";
        return new AstroAPODPicture("No image found", "null", date, errorExplanation);
    }

    public AstroImage imageFallBack(String search, Exception e){
        return AstroImage.getDefaultImage();
    }
}