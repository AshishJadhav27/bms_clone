package com.ashish.movieTicketBookingApp.controller;

import com.ashish.movieTicketBookingApp.dto.MovieDto;
import com.ashish.movieTicketBookingApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<?>addMovie(@RequestBody MovieDto movieDto){
        return ResponseEntity.ok(movieService.addMovie(movieDto));
    }

    @GetMapping("/movies")
    public List<?>allMovies(){
        return null;
    }
}
