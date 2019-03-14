package com.platzi.javatest.movies.service;

import com.platzi.javatest.movies.data.MovieRepository;
import com.platzi.javatest.model.Genre;
import com.platzi.javatest.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream().filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(Integer length) {
        return movieRepository.findAll().stream().filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByName(String name){
        return movieRepository.findAll().stream().filter(movie -> movie.getName().toLowerCase().contains(name)).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByDirector(String director) {
        return movieRepository.findAll().stream().filter(movie -> movie.getDirector().toLowerCase().contains((director))).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByTemplate(Movie template){
        return null;
    }
}
