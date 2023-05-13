package com.space.SpaceAPI.resource;

import com.space.SpaceAPI.models.AstroAPODPicture;
import com.space.SpaceAPI.models.astroImage.AstroImage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/space")
public class SpaceController {
    @Autowired
    private AstroAPI astroAPI;

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
    public @ResponseBody AstroImage getSearchImages(@PathVariable String search){
        return astroAPI.getImage(search);
    }
}