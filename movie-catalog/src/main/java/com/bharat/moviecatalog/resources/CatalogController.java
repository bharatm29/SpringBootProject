package com.bharat.moviecatalog.resources;

import com.bharat.moviecatalog.models.CatalogItem;
import com.bharat.moviecatalog.models.Movie;
import com.bharat.moviecatalog.models.UserRating;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "catalogCircuit", fallbackMethod = "getDefaultCatalog")
    public List<CatalogItem> getAllCatalog(@PathVariable String userId){
        UserRating userRating = restTemplate.getForObject("http://RATING-INFO-SERVICE/ratingsdata/users/" + userId, UserRating.class);
        
        return userRating.getUserRatings().stream()
            .map(rating -> {
                Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);
                return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
            })
            .toList();
    }

    private List<CatalogItem> getDefaultCatalog(String userId, Exception e){
        return List.of(new CatalogItem("No movie found", "", 0));
    }
}
