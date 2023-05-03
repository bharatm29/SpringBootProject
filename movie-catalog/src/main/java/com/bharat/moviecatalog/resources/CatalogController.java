package com.bharat.moviecatalog.resources;

import com.bharat.moviecatalog.models.*;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Get all the rated movies for the user",
                description = "This endpoint will display all the movies that the user rated in the API",
                responses = {
                    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"),
                        description = "Found all the rated movies for the user"),
                    @ApiResponse(responseCode = "404", description = "Could not resolve the user movies")
                })
    @GetMapping("/users/{userId}")
    @CircuitBreaker(name = "catalogCircuit", fallbackMethod = "getDefaultCatalog")
    public List<CatalogItem> getAllCatalog(@PathVariable String userId){
        UserRating userRating = restTemplate.getForObject(ratinguri + userId, UserRating.class);
        return userRating.getUserRatings().stream()
            .map(rating -> {
                MovieSummary movieSummary = restTemplate.getForObject(movieuri + rating.getMovieId(), MovieSummary.class);
                return new CatalogItem(movieSummary.getOriginal_title(), movieSummary.getOverview(), rating.getRating());
            })
            .toList();
    }

    @Operation(summary = "Search for a movie",
                responses = {
                    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"),
                        description = "Found the movies"),
                    @ApiResponse(responseCode = "500", description = "Error with movie-info-service")
                })
    @GetMapping("/search/{movieDesc}")
    public List<MovieSummary> getMovieSearches(@PathVariable String movieDesc){
        return restTemplate.getForObject(movieuri + "search/" + movieDesc, MovieLists.class).getResults();
    }

    @Operation(summary = "Create a new user and rate movies",
                requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json")),
                responses = {
                    @ApiResponse(responseCode = "200", description = "Created a user"),
                    @ApiResponse(responseCode = "500", description = "Cannot resolve rating-info-service")
                })
    @PostMapping("/users")
    public @ResponseBody String createUser(@RequestBody UserRating userRating){
        return restTemplate.postForObject(ratinguri, userRating, String.class);
    }

    @Operation(summary = "Add movie ratings for a user",
                responses = {
                    @ApiResponse(responseCode = "200", description = "added the ratings"),
                    @ApiResponse(responseCode = "500", description = "Cannot resolve rating-info-service")
                })
    @PutMapping("/users/{userid}")
    public @ResponseBody String updateUser(@PathVariable String userid, @RequestBody UserRating userRating){
        return restTemplate.patchForObject(ratinguri + userid, userRating, String.class);
    }

    //Fallback method for a fail attempt to another microservice.
    private List<CatalogItem> getDefaultCatalog(String userId, Exception e){
        return List.of(new CatalogItem("No movie found", "", 0));
    }
}
