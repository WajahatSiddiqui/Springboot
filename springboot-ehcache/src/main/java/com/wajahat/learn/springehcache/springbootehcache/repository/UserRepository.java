package com.wajahat.learn.springehcache.springbootehcache.repository;

import com.wajahat.learn.springehcache.springbootehcache.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wajahat on 13/7/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
}
