package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;

@Service
public class MovieService {

	private List<Movie> movies = new ArrayList<>();

	public MovieService() {

		movies.add(new Movie(1, "Thuppalo Thippalu", "English", 250));
		movies.add(new Movie(2, "Bahubali", "Telugu", 200));
		movies.add(new Movie(3, "Porata Simham", "English", 300));

	}

	public List<Movie> getAllMovies() {
		return movies;
	}

	public Movie getMovieById(int id) {
		return movies.stream()
				.filter(movie -> movie.getId() == id)
				.findFirst()
				.orElse(null);
	}

}