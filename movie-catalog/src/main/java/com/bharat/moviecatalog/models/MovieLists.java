package com.bharat.moviecatalog.models;

import java.util.List;

public class MovieLists {
    private List<MovieSummary> results;

    public MovieLists() {
    }

    public MovieLists(List<MovieSummary> results) {
        this.results = results;
    }

    public List<MovieSummary> getResults() {
        return results;
    }

    public void setResults(List<MovieSummary> results) {
        this.results = results;
    }
}
