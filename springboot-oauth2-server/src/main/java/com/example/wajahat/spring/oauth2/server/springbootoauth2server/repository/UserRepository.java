package com.example.wajahat.spring.oauth2.server.springbootoauth2server.repository;

import com.example.wajahat.spring.oauth2.server.springbootoauth2server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Collection;
import java.util.List;

/**
 * Created by wajahat on 19/5/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    @PreAuthorize("#oauth2.hasScope('read')")
    List<User> findAll();

    @PreAuthorize("#oauth2.hasScope('read')")
    User findById(Long Id);

    @PreAuthorize("#oauth2.hasScope('read')")
    User findByName(String name);

    @Override
    @PreAuthorize("#oauth2.hasScope('write')")
    <S extends User> S save(S entity);
}
