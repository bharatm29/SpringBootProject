package com.bharat.movieinfo.resources;

import com.bharat.movieinfo.models.MovieLists;
import com.bharat.movieinfo.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{movieId}")
    public MovieSummary getMovieInfo(@PathVariable String movieId){
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey;
        return restTemplate.getForObject(url, MovieSummary.class);
    }

    @GetMapping("/search/{movieDesc}")
    public MovieLists searchMovies(@PathVariable String movieDesc){
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=" + movieDesc;
        return restTemplate.getForObject(url,
                            MovieLists.class);
    }
}
