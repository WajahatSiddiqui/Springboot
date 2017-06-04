package com.wajahat.learn.springboot.lombok.springbootlombok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wajahat on 31/5/17.
 */
@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    Customer getCustomer(Long id) {
        return customerRepository.findOne(id);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
