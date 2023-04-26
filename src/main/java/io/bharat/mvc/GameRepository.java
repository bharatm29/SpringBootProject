package io.bharat.mvc;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.bharat.model.Game;

public interface GameRepository extends CrudRepository<Game, String>{
	
	public List<Game> findByTitleContainingIgnoreCase(String title);
	public List<Game> findByRating(String rating);
}
