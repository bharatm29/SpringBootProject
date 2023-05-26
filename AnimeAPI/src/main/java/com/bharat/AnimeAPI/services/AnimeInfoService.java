package com.bharat.AnimeAPI.services;

import com.bharat.AnimeAPI.models.Anime;
import com.bharat.AnimeAPI.models.AnimeDetails;
import com.bharat.AnimeAPI.models.AnimeSearch;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AnimeInfoService {
    @Value("${animeapi.uri}")
    private String animeApiUri;

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "search-cb", fallbackMethod = "searchFallback")
    public AnimeSearch searchAnime(String name){
        ResponseEntity<List<Anime>> searchResponse =
                restTemplate.exchange(animeApiUri + "search?keyw=" + name,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Anime>>(){
                        });

        return AnimeSearch.builder().animes(searchResponse.getBody()).build();
    }

    @CircuitBreaker(name = "details-cb", fallbackMethod = "detailsFallBack")
    public AnimeDetails getDetails(String animeId){
        return restTemplate.getForObject(animeApiUri + "anime-details/" + animeId, AnimeDetails.class);
    }

    public AnimeSearch searchFallback(String name, Exception e){
        return AnimeSearch.builder().animes(List.of(
                Anime.builder().animeTitle("Could not found").build()
        )).build();
    }

    public AnimeDetails detailsFallBack(String animeId, Exception e){
        return AnimeDetails.builder().animeTitle("Could not found this anime details").build();
    }
}
