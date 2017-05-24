package com.example.wajahat.spring.actuator.springbootactuatorendpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wajahat on 23/5/17.
 */
@RestController
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping("/customers")
    List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

}
