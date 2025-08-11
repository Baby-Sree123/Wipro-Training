package com.example.booking_app_rest_api.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.booking_app_rest_api.model.Movie;
import com.example.booking_app_rest_api.service.MovieService;


@RestController
@RequestMapping("/api")
public class MovieController {

	@Autowired
	private MovieService movieService;

	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	@GetMapping("/movie")
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();	
	}
	
	
	@GetMapping("/movie/{id}")
	public Optional<Movie> getMovie(@PathVariable Long id) {
		return movieService.getMovieById(id);
	}
	
	
	@PostMapping("/movie")
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
	    Movie savedMovie = movieService.saveMovie(movie);
	    return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/movie/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
	
}