package com.wajahat.project.jpa.mysql.springjpamysqlmoviesapi.service;

import com.wajahat.project.jpa.mysql.springjpamysqlmoviesapi.domain.Movie;
import com.wajahat.project.jpa.mysql.springjpamysqlmoviesapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wajahat on 12/5/17.
 */
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovie(Long id) {
        return movieRepository.findOne(id);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public String deleteMovie(Long id) {
        movieRepository.delete(id);
        return "Movie deleted with Id: " + id;
    }
}
