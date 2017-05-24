package com.wajahat.learn.spring.rest.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RestProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestProducerApplication.class, args);
	}
}
