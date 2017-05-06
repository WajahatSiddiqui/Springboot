package com.wajahat.learn.spring.rest.producer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wajahat on 6/5/17.
 */
@RestController
public class GreetingControllerImpl implements GreetingController {
    @Override
    public String getGreeting(@PathVariable("username") String username) {
        return String.format("Hello %s !", username);
    }
}
