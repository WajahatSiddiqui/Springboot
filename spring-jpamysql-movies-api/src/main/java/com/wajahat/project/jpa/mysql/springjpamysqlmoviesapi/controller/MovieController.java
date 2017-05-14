package com.wajahat.project.jpa.mysql.springjpamysqlmoviesapi.controller;

import com.wajahat.project.jpa.mysql.springjpamysqlmoviesapi.domain.Movie;
import com.wajahat.project.jpa.mysql.springjpamysqlmoviesapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wajahat on 12/5/17.
 */
@RestController
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.GET)
    public Movie getMovie(@PathVariable("movieId") Long id) {
        return movieService.getMovie(id);
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @RequestMapping(value = "/movies", method = RequestMethod.PUT)
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.DELETE)
    public String deleteMovie(@PathVariable("movieId") Long movieId) {
        return movieService.deleteMovie(movieId);
    }

}
