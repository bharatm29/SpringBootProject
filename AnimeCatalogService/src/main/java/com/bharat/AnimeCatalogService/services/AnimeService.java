package com.bharat.AnimeCatalogService.services;

import com.bharat.AnimeCatalogService.models.animesModels.*;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AnimeService {
    private final String ANIMEINFOAPI_URI = "http://ANIMEINFOAPI/anime";

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "search-cb", fallbackMethod = "searchFallback")
    public AnimeSearch searchAnime(String name){
        return restTemplate.getForObject(ANIMEINFOAPI_URI + "/search/" + name, AnimeSearch.class);
    }

    @CircuitBreaker(name = "details-cb", fallbackMethod = "detailsFallBack")
    public AnimeDetails getAnimeDetails(String animeid){
        return restTemplate.getForObject(ANIMEINFOAPI_URI + "/details/" + animeid, AnimeDetails.class);
    }

    @CircuitBreaker(name = "topAiring-cb", fallbackMethod = "topAiringFallback")
    public AnimeTopAiringSearch getTopAiringAnimes(){
        return restTemplate.getForObject(ANIMEINFOAPI_URI + "/top-airing", AnimeTopAiringSearch.class);
    }

    @CircuitBreaker(name = "genre-cb", fallbackMethod = "genresSearchFallBack")
    public AnimeGenresSearch getAnimesOfGenres(String genres){
        return restTemplate.getForObject(ANIMEINFOAPI_URI + "/genre/" + genres, AnimeGenresSearch.class);
    }

    public AnimeSearch searchFallback(String name, Exception e){
        return AnimeSearch.builder().animes(List.of(
                Anime.builder().animeTitle("Could not found").build()
        )).build();
    }

    public AnimeDetails detailsFallBack(String animeId, Exception e){
        return AnimeDetails.builder().animeTitle("Could not found this anime details").build();
    }

    public AnimeTopAiringSearch topAiringFallback(Exception e){
        return AnimeTopAiringSearch.builder().animes(
                List.of(AnimeTopAiring.builder().animeTitle("Could not find any animes").build())
        ).build();
    }

    public AnimeGenresSearch genresSearchFallBack(String genres, Exception e){
        return AnimeGenresSearch.builder().animes(
                List.of(AnimeGenres.builder().animeTitle("Could not find any anime of this genre").build())
        ).build();
    }
}
