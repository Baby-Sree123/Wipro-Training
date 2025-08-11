package com.example.movie_service.client;

import com.example.movie_service.dto.TheaterDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "theater-service", url = "http://localhost:4444")
public interface TheaterClient {

    @GetMapping("/theaters/{id}")
    TheaterDTO getTheaterById(@PathVariable("id") Long id);
}
