package com.wajahat.learn.spring.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ReservationRepository reservationRepository) {
		return args -> {
			Arrays.asList("Wajahat", "Siddiqui", "Phil", "Webb", "Josh", "Shasha")
					.forEach(n->reservationRepository.save(new Reservation(n)));
			reservationRepository.findAll().forEach(System.out::println);
			reservationRepository.findByReservationName("Wajahat").forEach(System.out::println);
		};
	}
}
