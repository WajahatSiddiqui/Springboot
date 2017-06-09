package com.wajahat.learn.springboot.lombok.springbootlombok;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wajahat on 31/5/17.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByName(String name);

    @Query(value = "SELECT new com.wajahat.learn.springboot.lombok.springbootlombok.CustomerAge( c.id, c.name ) " +
                   "FROM Customer c " +
                    "WHERE c.age = :age")
    List<CustomerAge> findAllByAge(@Param("age") int age);
}
