package com.app.bharat.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
		
	@RequestMapping("/movies")
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}
	
	@RequestMapping("/movies/{name}")
	public Movie getMovie(@PathVariable String name) {
		return movieService.getMovie(name);
	}
	
	@RequestMapping("/movies/rating/{rating}")
	public List<Movie> getMovie(@PathVariable int rating){
		return movieService.getMovie(rating);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/movies")
	public void addMovie(@RequestBody Movie movie) {
		movieService.addMovie(movie);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/movies/{name}")
	public void updateMovie(@RequestBody Movie movie) {
		movieService.updateMovie(movie);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/movies/{name}")
	public void deleteMovie(@PathVariable String name) {
		movieService.deleteMovie(name);
	}
}
