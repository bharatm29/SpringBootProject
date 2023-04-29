package com.bharat.moviecatalog.models;

import java.util.List;

public class UserRating {
    private List<Rating> userRatings;

    public UserRating() {}

    public UserRating(List<Rating> ratings) {
        this.userRatings = ratings;
    }

    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }
}
