package com.example.movie_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_service.model.Movie;
import com.example.movie_service.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepo;
	
	public List<Movie> getAllMovies() {  // retrives the movies
		return movieRepo.findAll();
	}
	
	public Movie saveMovie(Movie movie) {	//create a movie or this can be used to save the updated 
		return movieRepo.save(movie);
		
	}
	
	public Movie getMovieById(Long id) { // retrive movie by id
		return movieRepo.findById(id).get();
	}
	
	public void deleteMovie(Long id) {
		movieRepo.deleteById(id);
	}

}