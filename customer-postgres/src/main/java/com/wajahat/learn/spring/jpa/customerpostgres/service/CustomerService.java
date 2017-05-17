package com.wajahat.learn.spring.jpa.customerpostgres.service;

import com.wajahat.learn.spring.jpa.customerpostgres.domain.Customer;
import com.wajahat.learn.spring.jpa.customerpostgres.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wajahat on 16/5/17.
 */
@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findOne(id);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public String deleteCustomer(Long id) {
        customerRepository.delete(id);
        return "Customer with id: " + id + " deleted !!!";
    }
}
