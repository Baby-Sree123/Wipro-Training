package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@Bean
	public RouteLocator route(RouteLocatorBuilder builder) {
	    return builder.routes()
	            .route("CUSTOMER-SERVICE-MS", r -> r.path("/customers/**").uri("http://localhost:2222"))
	            .route("MOVIE-SERVICE-MS", r -> r.path("/movies/**").uri("http://localhost:3333"))
	            .route("BOOKING-SERVICE-MS", r -> r.path("/bookings/**").uri("http://localhost:1111"))
	            .route("THEATER-SERVICE-MS", r -> r.path("/theaters/**").uri("http://localhost:4444"))
	            .build();
	}




}
