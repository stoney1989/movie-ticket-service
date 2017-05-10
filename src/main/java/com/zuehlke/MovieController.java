package com.zuehlke;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MovieController {
	private ArrayList<SimpleMovie> simpleMovies = new ArrayList<>();
	private Map<Long, Movie> movies = new HashMap<>();
	
	
	public MovieController() {
		addMovie(new Movie(1, "Batman Begins", "poster", "plot", 2000, "gentre", new Rating("source","rating"), new Rating("source2","rating2")));
		addMovie(new Movie(2, "Ted", "poster", "plot", 2001, "gentre", new Rating("source","rating")));
		addMovie(new Movie(3, "Inception", "poster", "plot", 2000, "gentre", new Rating("source","rating")));
	}
	
	private void addMovie(Movie movie){
		movies.put(movie.getId(), movie);
		simpleMovies.add(new SimpleMovie(movie));
	}
	
	@GetMapping("/api/v1/movies")
	@ResponseBody
	public ArrayList<SimpleMovie> getMovies() {		
		return simpleMovies;		
	}
	
	@GetMapping("/api/v1/movies/{id}")
	@ResponseBody
	public Movie getMovie(@PathVariable long id) {		
		return movies.get(id);		
	}
}
