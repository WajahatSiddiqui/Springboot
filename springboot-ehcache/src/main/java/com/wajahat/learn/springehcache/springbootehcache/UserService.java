package com.wajahat.learn.springehcache.springbootehcache;

import com.wajahat.learn.springehcache.springbootehcache.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wajahat on 13/7/17.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    List<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }
}
