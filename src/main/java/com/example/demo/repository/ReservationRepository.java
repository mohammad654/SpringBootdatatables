package com.example.demo.repository;

import com.example.demo.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}

