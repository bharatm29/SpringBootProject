package com.bharat.moviecatalog.models;

import java.util.List;

/*
JSON payload for this class.
{
    "userid": 66,
    "userRatings": [
        {
            "movieId": 123,
            "rating": 1
        },
        {
            "movieId": 123,
            "rating": 2
        }
    ]
}
*/
public class UserRating {
    private String userid;
    private List<Rating> userRatings;

    public UserRating() {}

    public UserRating(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }

    public UserRating(String userid, List<Rating> userRatings) {
        this.userid = userid;
        this.userRatings = userRatings;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }

    @Override
    public String toString() {
        return "UserID: " + getUserid() + ", RatingsList: " + getUserRatings();
    }
}
