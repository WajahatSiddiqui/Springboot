package com.wajahat.learn.springehcache.springbootehcache;

import com.wajahat.learn.springehcache.springbootehcache.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootEhcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEhcacheApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {
            System.out.println("Printing User Repository");
            userRepository.findAll()
                    .forEach(System.out::println);
        };
	}
}
