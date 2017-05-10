package com.wajahat.learn.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by wajahat on 10/5/17.
 */
@RestController
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @RequestMapping("/reservations")
    Collection<Reservation> getAllReservation() {
        return this.reservationRepository.findAll();
    }
}
