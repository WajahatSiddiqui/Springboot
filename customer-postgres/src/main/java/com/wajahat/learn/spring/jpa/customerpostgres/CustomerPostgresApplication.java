package com.wajahat.learn.spring.jpa.customerpostgres;

import com.wajahat.learn.spring.jpa.customerpostgres.domain.Customer;
import com.wajahat.learn.spring.jpa.customerpostgres.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Consumer;

@SpringBootApplication
public class CustomerPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerPostgresApplication.class, args);
	}
}

@Component
class CommandLineRunnerImpl implements CommandLineRunner {

	private CustomerService customerService;

	@Autowired
	public CommandLineRunnerImpl(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public void run(String... args) throws Exception {
		Arrays.asList(new Customer("Raj", "Bong"),
				new Customer("Roy", "Pande"),
				new Customer("Raja", "Bheem"))
				.stream()
				.forEach(customer -> {
					customerService.addCustomer(customer);
				});
		customerService.getCustomers().forEach(System.out::println);
	}
}
