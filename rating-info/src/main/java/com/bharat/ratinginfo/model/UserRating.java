package com.bharat.ratinginfo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("users")
public class UserRating {
    @Id
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
}
