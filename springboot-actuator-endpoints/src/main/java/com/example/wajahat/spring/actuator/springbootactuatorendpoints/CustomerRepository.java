package com.example.wajahat.spring.actuator.springbootactuatorendpoints;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

/**
 * Created by wajahat on 23/5/17.
 */
@RepositoryRestController
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
