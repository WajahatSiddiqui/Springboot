package com.wajahat.learn.spring.rest.producer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wajahat on 6/5/17.
 */
public interface GreetingController {

    @RequestMapping("/greeting/{username}")
    public String getGreeting(@PathVariable("username") String username);
}
