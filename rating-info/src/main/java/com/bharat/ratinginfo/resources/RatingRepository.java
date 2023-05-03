package com.bharat.ratinginfo.resources;

import com.bharat.ratinginfo.model.UserRating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RatingRepository extends MongoRepository<UserRating, String> {
    @Query(value = "{}")
    public List<UserRating> findAll();
}
