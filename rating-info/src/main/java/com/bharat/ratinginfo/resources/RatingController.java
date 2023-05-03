package com.bharat.ratinginfo.resources;

import com.bharat.ratinginfo.model.Rating;
import com.bharat.ratinginfo.model.UserRating;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping("/{movieId}")
    public Rating getRatingInfo(@PathVariable String movieId){
        return new Rating(movieId, 4);
    }

    @GetMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable String userId){
        UserRating userRating = ratingRepository.findById(userId).orElse(null);
        System.out.println(userRating);
        return userRating;
    }

    @PostMapping("/users")
    public @ResponseBody String createUser(@RequestBody UserRating userRating){
        ratingRepository.save(userRating);
        return "Successfully created an user";
    }

    @PutMapping("/users/{userid}")
    public @ResponseBody String updateUser(@RequestBody UserRating userRating){
        ratingRepository.save(userRating);
        return "Successfully updated the user ratings";
    }
}
