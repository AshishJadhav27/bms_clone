package com.ashish.movieTicketBookingApp.controller;

import com.ashish.movieTicketBookingApp.dto.MovieDto;
import com.ashish.movieTicketBookingApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?>addMovie(@RequestBody MovieDto movieDto){
        return ResponseEntity.ok(movieService.addMovie(movieDto));
    }

    @GetMapping("/allmovies")
    public ResponseEntity<List<?>>getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/moviesByGenre")
    public ResponseEntity<List<?>>getByGenre(@RequestParam String genre){
        return ResponseEntity.ok(movieService.getMovieByGenre(genre));
    }

    @GetMapping("/moviesByLang")
    public ResponseEntity<List<?>>getByLang(@RequestParam String lang){
        return ResponseEntity.ok(movieService.getMovieByLang(lang));
    }

    @GetMapping("/moviesByTitle")
    public ResponseEntity<?>getBytitle(@RequestParam String title){
        return ResponseEntity.ok(movieService.getMovieByTitle(title));
    }


    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?>updateMovie(@PathVariable Long id, @RequestBody MovieDto movieDto){
        return ResponseEntity.ok(movieService.updateMovie(id,movieDto));
    }


    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
    }
}
