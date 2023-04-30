package com.app.bharat.movie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
	@Autowired
	private MovieRespository movieRespository;
	
	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<>();
		movieRespository.findAll().forEach(movies::add);
		return movies;
	}
	
	public Movie getMovie(String name) {
		return movieRespository.findById(name).orElse(null);
	}
	
	public List<Movie> getMovie(int rating) {
		return movieRespository.findByRating(rating);
	}
	
	public void addMovie(Movie movie) {
		movieRespository.save(movie);
	}
	
	public void updateMovie(Movie movie) {
		movieRespository.save(movie);
	}
	
	public void deleteMovie(String name) {
		movieRespository.deleteById(name);
	}
}
