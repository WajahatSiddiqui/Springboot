package com.wajahat.learn.springboot.docker.springbootdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootDockerApplication {

	@RequestMapping("/")
	public String greet() {
		return "Hello Docker World !";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerApplication.class, args);
	}
}
