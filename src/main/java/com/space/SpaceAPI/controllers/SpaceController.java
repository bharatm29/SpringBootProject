package com.space.SpaceAPI.controllers;

import com.space.SpaceAPI.models.AstroAPODPicture;
import com.space.SpaceAPI.models.astroImage.AstroImage;
import com.space.SpaceAPI.service.AstroAPI;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/space")
public class SpaceController {
    private final AstroAPI astroAPI;

    public SpaceController(AstroAPI astroAPI) {
        this.astroAPI = astroAPI;
    }

    @Operation(summary = "Get the Astronomy Picture of the Day for a day",
                responses = {
                    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"),
                                description = "Found the picture"),
                    @ApiResponse(responseCode = "404", description = "Could not found the picture - Check date format")
                })
    @GetMapping("/apod/{date}")
    public @ResponseBody AstroAPODPicture getAPOD(@PathVariable String date){
        return astroAPI.getAPOD(date);
    }

    @Operation(summary = "Search image from NASA API repository",
                responses = {
                    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"),
                                    description = "Found the images"),
                    @ApiResponse(responseCode = "404", description = "Could not find the images with the keyword")
                })
    @GetMapping("/images/{search}")
    public @ResponseBody AstroImage getSearchImages(@PathVariable String search,
                                                    @RequestParam(value = "page", defaultValue="1") String page){
        return astroAPI.getImage(search, page);
    }
}
