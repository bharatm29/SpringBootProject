package com.bharat.AnimeCatalogService.resources;

import com.bharat.AnimeCatalogService.models.AnimeResponse;
import com.bharat.AnimeCatalogService.models.AnimeUser;
import com.bharat.AnimeCatalogService.models.AnimeUserResponse;
import com.bharat.AnimeCatalogService.services.AnimeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anime/user")
public class CatalogController{
    /*
    User Actions: AnimeUser class
        1). Add animes - email and List<String>
        2). Update animes - email and List<String>
        3). show animes - email and List<AnimeDetails>
    FFA display:
        AnimeAPI call to different urls
    */
    @Autowired
    private AnimeUserService animeUserService;

    @GetMapping("/{email}")
    public @ResponseBody AnimeUserResponse getAnimeUser(@PathVariable String email){
        return animeUserService.getAnimeUser(email);
    }

    @PostMapping("/add")
    public @ResponseBody AnimeResponse addAnimeUser(@RequestBody AnimeUser animeUser){
        return animeUserService.addAnimeUser(animeUser);
    }

    @PutMapping("/{email}")
    public @ResponseBody AnimeResponse updateAnimeUser(@RequestBody AnimeUser animeUser, @PathVariable String email){
        return animeUserService.updateAnimeUser(email, animeUser);
    }
}
