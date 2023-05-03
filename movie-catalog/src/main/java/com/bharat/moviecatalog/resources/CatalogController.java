package com.bharat.moviecatalog.resources;

import com.bharat.moviecatalog.models.CatalogItem;
import com.bharat.moviecatalog.models.Movie;
import com.bharat.moviecatalog.models.UserRating;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private RestTemplate restTemplate;

    private String ratinguri = "http://RATING-INFO-SERVICE/ratingsdata/users/";
    private String movieuri = "http://MOVIE-INFO-SERVICE/movies/";

    @GetMapping("/users/{userId}")
    @CircuitBreaker(name = "catalogCircuit", fallbackMethod = "getDefaultCatalog")
    public List<CatalogItem> getAllCatalog(@PathVariable String userId){
        UserRating userRating = restTemplate.getForObject(ratinguri + userId, UserRating.class);
        return userRating.getUserRatings().stream()
            .map(rating -> {
                Movie movie = restTemplate.getForObject(movieuri + rating.getMovieId(), Movie.class);
                return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
            })
            .toList();
    }

    @PostMapping("/users")
    public @ResponseBody String createUser(@RequestBody UserRating userRating){
        return restTemplate.postForObject(ratinguri, userRating, String.class);
    }

    @PutMapping("/users/{userid}")
    public @ResponseBody String updateUser(@PathVariable String userid, @RequestBody UserRating userRating){
        return restTemplate.patchForObject(ratinguri + userid, userRating, String.class);
    }

    //Fallback method for a fail attempt to another microservice.
    private List<CatalogItem> getDefaultCatalog(String userId, Exception e){
        return List.of(new CatalogItem("No movie found", "", 0));
    }
}
