package com.bharat.AnimeCatalogService.resources;

import com.bharat.AnimeCatalogService.models.animesModels.AnimeDetails;
import com.bharat.AnimeCatalogService.models.animesModels.AnimeGenresSearch;
import com.bharat.AnimeCatalogService.models.animesModels.AnimeSearch;
import com.bharat.AnimeCatalogService.models.animesModels.AnimeTopAiringSearch;
import com.bharat.AnimeCatalogService.services.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anime")
public class AnimeController{
    @Autowired
    private AnimeService animeService;

    @GetMapping("/search/{name}")
    public AnimeSearch searchAnime(@PathVariable String name, @RequestParam(value = "page", defaultValue = "1") String page){
        return animeService.searchAnime(name, page);
    }

    @GetMapping("/details/{animeId}")
    public AnimeDetails getDetails(@PathVariable String animeId){
        return animeService.getAnimeDetails(animeId);
    }

    @GetMapping("/top-airing")
    public AnimeTopAiringSearch getTopAiringAnimes(@RequestParam(defaultValue = "1") String page){
        return animeService.getTopAiringAnimes(page);
    }

    @GetMapping("/genre/{genre}")
    public AnimeGenresSearch getGenresAnime(@PathVariable String genre, @RequestParam(defaultValue = "1") String page){
        return animeService.getAnimesOfGenres(genre, page);
    }
}
