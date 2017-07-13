package com.wajahat.learn.springehcache.springbootehcache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wajahat on 13/7/17.
 */
@Component
@Slf4j
public class UserCache {

    @Autowired
    private UserService userService;

    @Cacheable(value = "usersCache", key="#name")
    public List<User> getUserByName(String name) {
        log.info("Retrieving from db for name: " + name);
        return userService.getUserByName(name);
    }
}
