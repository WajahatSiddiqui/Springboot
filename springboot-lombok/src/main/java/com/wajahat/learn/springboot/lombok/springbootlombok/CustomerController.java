package com.wajahat.learn.springboot.lombok.springbootlombok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by wajahat on 31/5/17.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @RequestMapping(value = "/{customerId}/address", method = RequestMethod.GET)
    public String getAddress(@PathVariable("customerId") Long customerId) {
        return ((Customer) customerService.getCustomer(customerId)).getAddress();
    }

    @RequestMapping(value = "/{age}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerAge>> getCustomerByAge(@PathVariable("age") int age) {
        List<CustomerAge> list = customerService.findAllByAge(age);
        if (list == null || list.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        //return new ResponseEntity<List<String>>(list, HttpStatus.OK);
        return ResponseEntity.ok(list);
    }
}
