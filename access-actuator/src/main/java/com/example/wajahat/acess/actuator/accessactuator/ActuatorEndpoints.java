package com.example.wajahat.acess.actuator.accessactuator;

import com.example.wajahat.acess.actuator.accessactuator.health.Health;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Optional;

/**
 * Created by wajahat on 21/8/17.
 */
@Component
public class ActuatorEndpoints {
    private static String serviceUriHealth = "http://localhost:8000/manage/health";
    private static String serviceUriShutdown = "http://localhost:8000/manage/shutdown";

    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders;

    public ActuatorEndpoints() {
        this.restTemplate = new RestTemplate();
        this.httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    }

    public Optional<Health> getHealth() {
        HttpEntity<String> entity = new HttpEntity<String>("parameters", httpHeaders);
        ResponseEntity<Health> responseEntity = restTemplate.exchange(serviceUriHealth, HttpMethod.GET, entity, Health.class);
        return Optional.ofNullable(responseEntity.getBody());
    }

    public boolean shutdown() {
        HttpEntity<String> entity = new HttpEntity<String>("parameters", httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(serviceUriShutdown, HttpMethod.POST, entity, String.class);
        System.out.println(responseEntity.toString());
        return responseEntity.getBody().contains("Shutting down, bye...");
    }
}