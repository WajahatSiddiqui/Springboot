package com.wajahat.project.jpa.mysql.springjpamysqlmoviesapi;

import com.wajahat.project.jpa.mysql.springjpamysqlmoviesapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringJpamysqlMoviesApiApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(SpringJpamysqlMoviesApiApplication.class, args);
	}

	private MovieRepository movieRepository;

	@Autowired
	public SpringJpamysqlMoviesApiApplication(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		movieRepository.findAll().forEach(System.out::println);
	}
}