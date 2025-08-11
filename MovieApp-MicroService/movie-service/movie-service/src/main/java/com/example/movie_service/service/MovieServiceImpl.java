package com.example.movie_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_service.client.TheaterClient;
import com.example.movie_service.dto.TheaterDTO;
import com.example.movie_service.exception.ResourceNotFoundException;
import com.example.movie_service.model.Movie;
import com.example.movie_service.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{
	
	@Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterClient theaterClient;

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Long id, Movie movie) {
        Movie existing = getMovieById(id);
        existing.setTitle(movie.getTitle());
        existing.setGenre(movie.getGenre());
        existing.setTheaterId(movie.getTheaterId());
        return movieRepository.save(existing);
    }

    @Override
    public void deleteMovie(Long id) {
        Movie existing = getMovieById(id);
        movieRepository.delete(existing);
    }
    
    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie with ID " + id + " not found"));
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public TheaterDTO getMovieTheater(Long movieId) {
        Movie movie = getMovieById(movieId);
        return theaterClient.getTheaterById(movie.getTheaterId());
    }


}
