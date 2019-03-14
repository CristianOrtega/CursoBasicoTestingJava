package com.platzi.javatest.movies.service;

import com.platzi.javatest.movies.data.MovieRepository;
import com.platzi.javatest.model.Genre;
import com.platzi.javatest.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setup() throws Exception{
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan"),
                        new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan"),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY, "Peter Farrelly, Bobby Farrelly"),
                        new Movie(4, "Super 8", 112, Genre.THRILLER, "J. J. Abrams"),
                        new Movie(5, "Scream", 111, Genre.HORROR, "Wes Craven"),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY, "Chris Columbus, Raja Gosnell, Peter Hewitt, Rod Daniel"),
                        new Movie(7, "Matrix", 136, Genre.ACTION, "Hermanas Wachowski"),
                        new Movie(8, "Dark Knight Rises", 152, Genre.ACTION, "Christopher Nolan"),
                        new Movie(9, "The Matrix Reloaded", 136, Genre.ACTION, "Hermanas Wachowski"),
                        new Movie(10, "The Matrix Revolutions", 136, Genre.ACTION, "Hermanas Wachowski")
                ));
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void returnMovieByGenre() {
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        assertThat(getMovieIds(movies), is(Arrays.asList(3, 6)));
    }

    @Test
    public void returnMoviesByLength(){
        Collection<Movie> movies = movieService.findMoviesByLength(119);
        assertThat(getMovieIds(movies), is(Arrays.asList(2, 3, 4, 5, 6)));
    }

    @Test
    public void returnMovieByName(){
        Collection<Movie> movies = movieService.findMoviesByName("matrix");
        assertThat(getMovieIds(movies), is(Arrays.asList(7, 9, 10)));
    }

    @Test
    public void returnMovieByDirector(){
        Collection<Movie> movies = movieService.findMoviesByDirector("nolan");
        assertThat(getMovieIds(movies), is(Arrays.asList(1, 2, 8)));
    }

    @Test
    public void returnMovieByNameAndDuration(){

    }

    @Test
    public void returnMovieByNameAndGenre(){

    }

    @Test
    public void returnMovieByNameDurantionAndGenre(){

    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}