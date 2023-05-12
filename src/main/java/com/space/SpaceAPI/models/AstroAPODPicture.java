package com.space.SpaceAPI.models;

public class AstroAPODPicture {
    private String title, hdurl, date, explanation;

    public AstroAPODPicture() {}

    public AstroAPODPicture(String title, String hdurl, String date, String explanation) {
        this.title = title;
        this.hdurl = hdurl;
        this.date = date;
        this.explanation = explanation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
