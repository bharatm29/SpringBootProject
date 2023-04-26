package io.bharat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GameData {
	@Id
	private String rank;
	private String title, team, rating, times_listed, number_of_reviews, genres, plays, playing, backlogs, wishlist;
	
	public GameData() {
		super();
	}

	public GameData(String rank, String title, String team, String rating, String times_listed, String number_of_reviews,
			String genres, String plays, String playing, String backlogs, String wishlist) {
		super();
		this.rank = rank;
		this.title = title;
		this.team = team;
		this.rating = rating;
		this.times_listed = times_listed;
		this.number_of_reviews = number_of_reviews;
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

	public String getTimes_listed() {
		return times_listed;
	}

	public void setTimes_listed(String times_listed) {
		this.times_listed = times_listed;
	}

	public String getNumber_of_reviews() {
		return number_of_reviews;
	}

	public void setNumber_of_reviews(String number_of_reviews) {
		this.number_of_reviews = number_of_reviews;
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
