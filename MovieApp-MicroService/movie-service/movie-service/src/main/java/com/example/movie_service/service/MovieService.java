package com.example.movie_service.service;

import com.example.movie_service.dto.TheaterDTO;
import com.example.movie_service.model.Movie;

import java.util.List;

public interface MovieService {
    Movie createMovie(Movie movie);
    Movie updateMovie(Long id, Movie movie);
    void deleteMovie(Long id);
    Movie getMovieById(Long id);
    List<Movie> getAllMovies();
    TheaterDTO getMovieTheater(Long movieId);
}
