package com.wajahat.learn.springboot.lombok.springbootlombok;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wajahat on 31/5/17.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByName(String name);
}
