package com.example.booking_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.booking_service.dto.MovieDTO;

@FeignClient(name = "movie-Service", url = "http://localhost:3333")
public interface MovieClient {
 

    @GetMapping("/movies/{id}")
    MovieDTO getMovieById(@PathVariable("id") Long id);
}


