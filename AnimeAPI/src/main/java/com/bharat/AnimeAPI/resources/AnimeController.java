package com.bharat.AnimeAPI.resources;

import com.bharat.AnimeAPI.models.AnimeDetails;
import com.bharat.AnimeAPI.models.AnimeGenresSearch;
import com.bharat.AnimeAPI.models.AnimeSearch;
import com.bharat.AnimeAPI.models.AnimeTopAiringSearch;
import com.bharat.AnimeAPI.services.AnimeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anime")
public class AnimeController {
    @Autowired
    private AnimeInfoService animeInfoService;

    @GetMapping("/search/{name}")
    public AnimeSearch searchAnime(@PathVariable String name, @RequestParam(defaultValue = "1") String page){
        return animeInfoService.searchAnime(name, page);
    }

    @GetMapping("/details/{animeId}")
    public AnimeDetails getDetails(@PathVariable String animeId){
        return animeInfoService.getDetails(animeId);
    }

    @GetMapping("/top-airing")
    public AnimeTopAiringSearch getTopAiringAnimes(@RequestParam(defaultValue = "1") String page){
        return animeInfoService.getTopAiring(page);
    }

    @GetMapping("/genre/{genre}")
    public AnimeGenresSearch getGenresAnime(@PathVariable String genre, @RequestParam(defaultValue = "1") String page){
        return animeInfoService.getGenreAnime(genre, page);
    }
}
