package com.wajahat.learn.spring.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

/**
 * Created by wajahat on 10/5/17.
 */
@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // select * from reservation where reservationName = 'reservationName';
    Collection<Reservation> findByReservationName(@Param("reservationName") String reservationName);
}
