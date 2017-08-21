package com.example.wajahat.acess.actuator.accessactuator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessActuatorApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ActuatorEndpoints actuatorEndpoints) {
		return args -> {
			System.out.println(actuatorEndpoints.getHealth());
			System.out.println(actuatorEndpoints.shutdown());
		};
	}
}