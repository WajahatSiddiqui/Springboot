package com.wajahat.learn.spring.jpa.customerpostgres.repository;

import com.wajahat.learn.spring.jpa.customerpostgres.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wajahat on 16/5/17.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
