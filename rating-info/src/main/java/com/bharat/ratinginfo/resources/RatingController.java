package com.bharat.ratinginfo.resources;

import com.bharat.ratinginfo.model.Rating;
import com.bharat.ratinginfo.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {
    @GetMapping("/{movieId}")
    public Rating getRatingInfo(@PathVariable String movieId){
        return new Rating(movieId, 4);
    }

    @GetMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable String userId){
        List<Rating> ratings = List.of(new Rating("550", 1),
                new Rating("551", 69),
                new Rating("552", 99));

        return new UserRating(ratings);
    }
}
