package com.wajahat.project.jpa.mysql.springjpamysqlmoviesapi;

import com.wajahat.project.jpa.mysql.springjpamysqlmoviesapi.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpamysqlMoviesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpamysqlMoviesApiApplication.class, args);
	}

	CommandLineRunner runner(MovieRepository movieRepository) {
		return args -> {
			movieRepository.findAll().forEach(System.out::println);
		};
	}
}
