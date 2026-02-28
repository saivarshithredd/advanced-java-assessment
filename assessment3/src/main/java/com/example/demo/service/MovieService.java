package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.Movie;

public interface MovieService {

    List<Movie> getAllMovies();
    Movie saveMovie(Movie movie);
    Movie getMovieById(Long id);
    Movie updateMovie(Movie movie);
    void deleteMovie(Long id);
   
}
