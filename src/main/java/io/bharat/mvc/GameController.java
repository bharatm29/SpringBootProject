package io.bharat.mvc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.bharat.model.Game;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	private GameRepository gameRepository;
	
	@GetMapping("/")
	public List<Game> getAllGames(){
		List<Game> games = new ArrayList<>();
		List<Game> buff= new ArrayList<>();
		
		gameRepository.findAll().forEach(buff::add);
		
		games = buff.stream().sorted((a, b) -> a.getRank().compareTo(b.getRank())).toList();
		return games;
	}
	
	@Operation(summary = "Get all games matching the title", 
				responses = {
						@ApiResponse(responseCode = "200", description = "Found all the titles",
								content = @Content(mediaType = "application/json")),
						@ApiResponse(responseCode = "404", description = "Could not find the titles")
				})
	@GetMapping("/{title}")
	public List<Game> getGame(@PathVariable String title) {
		List<Game> games = new ArrayList<>();
		gameRepository.findByTitleContainingIgnoreCase(title).forEach(games::add);
		return games.stream().sorted(Comparator.comparing(Game::getRank)).toList();
	}
	
	@GetMapping("/rating/{rating}")
	public List<Game> getByRating(@PathVariable String rating){
		List<Game> games = new ArrayList<>();

		gameRepository.findByRating(rating).forEach(games::add);
		
		return games;
	}
}
