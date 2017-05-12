package com.wajahat.project.jpa.mysql.springjpamysqlmoviesapi.repository;

import com.wajahat.project.jpa.mysql.springjpamysqlmoviesapi.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wajahat on 12/5/17.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
