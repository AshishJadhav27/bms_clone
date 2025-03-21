package com.ashish.movieTicketBookingApp.repository;

import com.ashish.movieTicketBookingApp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie,Long> {

}
