package com.wajahat.learn.spring.jpa.customerpostgres.controller;

import com.wajahat.learn.spring.jpa.customerpostgres.domain.Customer;
import com.wajahat.learn.spring.jpa.customerpostgres.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wajahat on 16/5/17.
 */
@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable("customerId") Long customerId) {
        return customerService.getCustomer(customerId);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.PUT)
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable("customerId") Long customerId) {
        return customerService.deleteCustomer(customerId);
    }
}
