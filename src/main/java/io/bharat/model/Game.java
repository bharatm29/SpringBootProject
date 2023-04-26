package io.bharat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Game {
	@Id
	private String rank;

	private String title, team, rating, timesListed, numberOfReviews, genres, plays, playing, backlogs, wishlist;

	public Game() {
		super();
	}

	public Game(String rank, String title, String team, String rating, String timesListed, String numberOfReviews,
			String genres, String plays, String playing, String backlogs, String wishlist) {
		super();
		this.rank = rank;
		this.title = title;
		this.team = team;
		this.rating = rating;
		this.timesListed = timesListed;
		this.numberOfReviews = numberOfReviews;
		this.genres = genres;
		this.plays = plays;
		this.playing = playing;
		this.backlogs = backlogs;
		this.wishlist = wishlist;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getTimesListed() {
		return timesListed;
	}

	public void setTimesListed(String timesListed) {
		this.timesListed = timesListed;
	}

	public String getNumberOfReviews() {
		return numberOfReviews;
	}

	public void setNumberOfReviews(String numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getPlays() {
		return plays;
	}

	public void setPlays(String plays) {
		this.plays = plays;
	}

	public String getPlaying() {
		return playing;
	}

	public void setPlaying(String playing) {
		this.playing = playing;
	}

	public String getBacklogs() {
		return backlogs;
	}

	public void setBacklogs(String backlogs) {
		this.backlogs = backlogs;
	}

	public String getWishlist() {
		return wishlist;
	}

	public void setWishlist(String wishlist) {
		this.wishlist = wishlist;
	}	
}
