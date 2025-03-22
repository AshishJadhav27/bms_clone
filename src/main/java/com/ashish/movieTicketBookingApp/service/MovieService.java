package com.ashish.movieTicketBookingApp.service;

import com.ashish.movieTicketBookingApp.dto.MovieDto;
import com.ashish.movieTicketBookingApp.entity.Movie;
import com.ashish.movieTicketBookingApp.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;
    public Movie addMovie(MovieDto movieDto) {

        Movie movie = new Movie();

        movie.setTitle(movieDto.getTitle());
        movie.setDescription(movieDto.getDescription());
        movie.setLanguage(movieDto.getLanguage());
        movie.setGenre(movieDto.getGenre());
        movie.setDuration(movieDto.getDuration());
        movie.setReleaseDate(movieDto.getReleaseDate());


        return movieRepo.save(movie);

    }

    public List<?>getAllMovies(){
        List<Movie> allMovies=movieRepo.findAll();
        return allMovies;
    }

    public List<?>getMovieByGenre(String genre){
        Optional<List<Movie>> movieList=movieRepo.findByGenre(genre);
        if (movieList.isPresent()){
            return movieList.get();
        }else{
            throw new RuntimeException("No movies available in "+genre+" genre");
        }

    }

    public List<?>getMovieByLang(String lang){
        Optional<List<Movie>> movieList=movieRepo.findByLanguage(lang);
        if (movieList.isPresent()){
            return movieList.get();
        }else{
            throw new RuntimeException("No movies available in "+lang+" language");
        }

    }

    public Movie getMovieByTitle(String title){
        Optional<Movie> movieBox=movieRepo.findByName(title);
        if (movieBox.isPresent()){
            return movieBox.get();
        }else{
            throw new RuntimeException("No movies available with title: - "+title);
        }

    }

    public Movie updateMovie (Long id, MovieDto movieDto){
        Movie movie = movieRepo.findById(id)
                    .orElseThrow(()-> new RuntimeException("Movie not found with id: "+id));

        movie.setTitle(movieDto.getTitle());
        movie.setDescription(movieDto.getDescription());
        movie.setLanguage(movieDto.getLanguage());
        movie.setGenre(movieDto.getGenre());
        movie.setDuration(movieDto.getDuration());
        movie.setReleaseDate(movieDto.getReleaseDate());


        return movieRepo.save(movie);
    }

    public void deleteMovie(Long id){
        movieRepo.deleteById(id);
    }
}
