package io.bharat.mvc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.bharat.model.Game;

@RestController
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	private GameRepository gameRepository;
	
	@RequestMapping("/")
	public List<Game> getAllGames(){
		List<Game> games = new ArrayList<>();
		List<Game> buff= new ArrayList<>();
		
		gameRepository.findAll().forEach(buff::add);
		
		games = buff.stream().sorted((a, b) -> a.getRank().compareTo(b.getRank())).toList();
		return games;
	}
	
	@RequestMapping("/{title}")
	public List<Game> getGame(@PathVariable String title) {
		List<Game> games = new ArrayList<>();
		gameRepository.findByTitleContainingIgnoreCase(title).forEach(games::add);
		return games.stream().sorted(Comparator.comparing(Game::getRank)).toList();
	}
	
	@RequestMapping("/rating/{rating}")
	public List<Game> getByRating(@PathVariable String rating){
		List<Game> games = new ArrayList<>();

		gameRepository.findByRating(rating).forEach(games::add);
		
		return games;
	}
}
