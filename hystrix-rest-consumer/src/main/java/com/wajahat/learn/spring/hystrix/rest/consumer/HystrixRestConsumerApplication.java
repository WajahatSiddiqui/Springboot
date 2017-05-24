package com.wajahat.learn.spring.hystrix.rest.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
public class HystrixRestConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixRestConsumerApplication.class, args);
	}
}
