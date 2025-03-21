package com.ashish.movieTicketBookingApp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String genre;
    private String language;
    private int duration;
    private LocalDate releaseDate;

    @OneToMany(mappedBy = "movie",fetch = FetchType.LAZY)
    private List<Show>shows;
}
