package com.wajahat.learn.springboot.lombok.springbootlombok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootLombokApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLombokApplication.class, args);
	}

	@Autowired
	private CustomerRepository customerRepository;


	@Override
	public void run(String... args) throws Exception {
		customerRepository.findAll()
				.forEach(System.out::println);
	}
}
