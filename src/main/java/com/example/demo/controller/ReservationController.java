package com.example.demo.controller;

import java.util.Collections;

import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Reservation;

@RestController
@RequestMapping("api")
public class ReservationController {

    protected static final Logger logger = LogManager.getLogger();

    ReservationService reservationService;
    
    @Autowired
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;

    }

    @PostMapping(value = "/reservation", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Reservation> saveReservation( @RequestBody final Reservation reservation) {

        logger.info("Inside 'saveReservation'");

        reservationService.save(reservation);
        return ResponseEntity.ok(reservation) ;

    }

    @GetMapping(value = "/reservation/{id}", produces = "application/json")
    public ResponseEntity<Reservation> getReservationById( @PathVariable final Long id) {

        logger.info("Inside 'getReservationById'");

        try {
            Reservation reservation = reservationService.findById(id).orElse(null);
            return ResponseEntity.ok( reservation);
        } catch (Exception e) {
            return ResponseEntity.ok( null);
        }

    }

    @GetMapping(value = "/reservation", produces = "application/json")
    public ResponseEntity<Iterable<Reservation>> getAllReservations() {

        logger.info("Inside 'getAllReservations'");

        try {
            Iterable<Reservation> reservations = reservationService.findAll();
            return ResponseEntity.ok( reservations);
        } catch (Exception e) {
            return ResponseEntity.ok( Collections.emptyList());
        }

    }

    @DeleteMapping(value = "/reservation/{reservation}", produces = "text/plain")
    public ResponseEntity<String> deleteReservationById( @PathVariable final Long id) {

        logger.info("Inside 'deleteReservationById'");

        try {
            reservationService.deleteById(id);
            return ResponseEntity.ok( "Item with id: " + id + " is deleted");
        } catch (Exception e) {
            return ResponseEntity.ok( "Item with id: " + id + " may NOT be deleted");
        }

    }

}

