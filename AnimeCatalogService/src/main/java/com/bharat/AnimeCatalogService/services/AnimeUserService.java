package com.bharat.AnimeCatalogService.services;

import com.bharat.AnimeCatalogService.models.animesModels.AnimeDetails;
import com.bharat.AnimeCatalogService.models.AnimeResponse;
import com.bharat.AnimeCatalogService.models.AnimeUser;
import com.bharat.AnimeCatalogService.models.AnimeUserResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AnimeUserService {
    private final String USER_URI = "http://USERSERVICE/anime/user";
    private final String ANIMEINFOAPI_URI = "http://ANIMEINFOAPI/anime/details/";

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "post-cb", fallbackMethod = "postFallback")
    public AnimeResponse addAnimeUser(AnimeUser animeUser){
        AnimeResponse animeResponse = restTemplate.postForObject(USER_URI + "/add", animeUser, AnimeResponse.class);
        return animeResponse;
    }

    @CircuitBreaker(name = "get-cb", fallbackMethod = "getFallback")
    public AnimeUserResponse getAnimeUser(String email){
        AnimeUser animeUser = restTemplate.getForObject(USER_URI + "/" + email, AnimeUser.class);
        return AnimeUserResponse.builder()
                .email(animeUser.getEmail())
                .animes(animeUser.getAnimeIds().stream().map(
                        animeId -> restTemplate.getForObject(ANIMEINFOAPI_URI + animeId, AnimeDetails.class)
                ).toList())
                .build();
    }

    @CircuitBreaker(name = "update-cb", fallbackMethod = "updateFallback")
    public AnimeResponse updateAnimeUser(String email, AnimeUser animeUser){
        return restTemplate.patchForObject(USER_URI + "/" + email, animeUser, AnimeResponse.class);
    }

    public AnimeUserResponse getFallback(String email, Exception e){
        return AnimeUserResponse.builder().email("Could not resolve the user").build();
    }

    public AnimeResponse postFallback(AnimeUser animeUser, Exception e){
        return AnimeResponse.builder().message("Could not add the user").build();
    }

    public AnimeResponse updateFallback(String email, Exception e){
        return AnimeResponse.builder().message("Could not update the user").build();
    }
}
