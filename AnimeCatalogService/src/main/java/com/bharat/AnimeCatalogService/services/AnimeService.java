package com.bharat.AnimeCatalogService.services;

import com.bharat.AnimeCatalogService.models.animesModels.AnimeDetails;
import com.bharat.AnimeCatalogService.models.animesModels.AnimeGenresSearch;
import com.bharat.AnimeCatalogService.models.animesModels.AnimeSearch;
import com.bharat.AnimeCatalogService.models.animesModels.AnimeTopAiringSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AnimeService {
    private final String ANIMEINFOAPI_URI = "http://ANIMEINFOAPI/anime";

    @Autowired
    private RestTemplate restTemplate;

    public AnimeSearch searchAnime(String name){
        return restTemplate.getForObject(ANIMEINFOAPI_URI + "/search/" + name, AnimeSearch.class);
    }

    public AnimeDetails getAnimeDetails(String animeid){
        return restTemplate.getForObject(ANIMEINFOAPI_URI + "/details/" + animeid, AnimeDetails.class);
    }

    public AnimeTopAiringSearch getTopAiringAnimes(){
        return restTemplate.getForObject(ANIMEINFOAPI_URI + "/top-airing", AnimeTopAiringSearch.class);
    }

    public AnimeGenresSearch getAnimesOfGenres(String genres){
        return restTemplate.getForObject(ANIMEINFOAPI_URI + "/genre/" + genres, AnimeGenresSearch.class);
    }
}
