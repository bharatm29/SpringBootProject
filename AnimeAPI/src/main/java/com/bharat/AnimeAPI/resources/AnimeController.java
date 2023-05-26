package com.bharat.AnimeAPI.resources;

import com.bharat.AnimeAPI.models.AnimeDetails;
import com.bharat.AnimeAPI.models.AnimeSearch;
import com.bharat.AnimeAPI.services.AnimeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/anime")
public class AnimeController {
    @Autowired
    private AnimeInfoService animeInfoService;

    @GetMapping("/search/{name}")
    public AnimeSearch searchAnime(@PathVariable String name){
        return animeInfoService.searchAnime(name);
    }

    @GetMapping("/details/{animeId}")
    public AnimeDetails getDetails(@PathVariable String animeId){
        return animeInfoService.getDetails(animeId);
    }
}
