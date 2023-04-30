package com.app.bharat.movie;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie {
	
	@Id
	private String name;
	private int rating;
	private String desc;
	
	public Movie() {}
	
	public Movie(String name, String desc, int rating) {
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
