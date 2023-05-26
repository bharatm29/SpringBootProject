package com.bharat.AnimeCatalogService.resources;

import com.bharat.AnimeCatalogService.models.animesModels.AnimeDetails;
import com.bharat.AnimeCatalogService.models.animesModels.AnimeGenresSearch;
import com.bharat.AnimeCatalogService.models.animesModels.AnimeSearch;
import com.bharat.AnimeCatalogService.models.animesModels.AnimeTopAiringSearch;
import com.bharat.AnimeCatalogService.services.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anime")
public class AnimeController{
    @Autowired
    private AnimeService animeService;

    @GetMapping("/search/{name}")
    public AnimeSearch searchAnime(@PathVariable String name){
        return animeService.searchAnime(name);
    }

    @GetMapping("/details/{animeId}")
    public AnimeDetails getDetails(@PathVariable String animeId){
        return animeService.getAnimeDetails(animeId);
    }

    @GetMapping("/top-airing")
    public AnimeTopAiringSearch getTopAiringAnimes(){
        return animeService.getTopAiringAnimes();
    }

    @GetMapping("/genre/{genre}")
    public AnimeGenresSearch getGenresAnime(@PathVariable String genre){
        return animeService.getAnimesOfGenres(genre);
    }
}
