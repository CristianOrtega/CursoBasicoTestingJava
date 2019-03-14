package com.platzi.javatest.movies.data;


import com.platzi.javatest.model.Genre;
import com.platzi.javatest.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepository;
    private DataSource dataSource;

    @Before
    public void setUp() throws SQLException {
        dataSource =
                new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void loadAllMovies() throws SQLException {
        Collection<Movie> movies = movieRepository.findAll();
        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan"),
                new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan"),
                new Movie(3, "Matrix", 136, Genre.ACTION, "Hermanas Wachowski")
        )));
    }

    @Test
    public void loadAllMoviesById() {
        Movie movie = movieRepository.findById(2);
        assertThat(movie, is(new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan")));
    }

    @Test
    public void insertAMovie() {
        Movie movie = new Movie(4,"Super 8", 112, Genre.THRILLER, "J. J. Abrams");
        movieRepository.saveOrUpdate(movie);
        Movie movieDB = movieRepository.findById(4);
        assertThat(movieDB, is(movie));
    }

    @After
    public void tearDown() throws Exception {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}

