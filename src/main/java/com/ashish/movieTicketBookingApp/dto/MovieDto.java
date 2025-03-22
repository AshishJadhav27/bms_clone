package com.ashish.movieTicketBookingApp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieDto {
    private String title;
    private String description;
    private String genre;
    private String language;
    private int duration;
    private LocalDate releaseDate;
}
