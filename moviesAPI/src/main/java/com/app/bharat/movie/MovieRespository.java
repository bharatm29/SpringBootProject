package com.app.bharat.movie;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MovieRespository extends CrudRepository<Movie, String>{
	public List<Movie> findByRating(int rating);
}
