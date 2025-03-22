package com.ashish.movieTicketBookingApp.repository;

import com.ashish.movieTicketBookingApp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepo extends JpaRepository<Movie,Long> {

    Optional<List<Movie>> findByGenre(String genre);

    Optional<List<Movie>> findByLanguage(String lang);

    Optional<Movie> findByName(String title);
}
