package com.wajahat.learn.spring.hystrix.rest.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wajahat on 6/5/17.
 */
@Service
public class GreetingService {
    @HystrixCommand(fallbackMethod = "defaultGreeting")
    public String getGreeting(String username) {
        return new RestTemplate()
                .getForObject("http://localhost:8010/greeting/{username}",
                        String.class, username);
    }

    private String defaultGreeting(String username) {
        return "Hello User!";
    }
}
