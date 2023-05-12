package com.space.SpaceAPI.resource;

import com.space.SpaceAPI.models.AstroPicture;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/space")
public class SpaceController {

    @GetMapping("/apod/{date}")
    public @ResponseBody AstroPicture getAPOD(@PathVariable String date){
        
    }
}
