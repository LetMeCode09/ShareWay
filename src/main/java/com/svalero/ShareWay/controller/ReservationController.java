package com.svalero.ShareWay.controller;

import com.svalero.ShareWay.domain.Reservation;
import com.svalero.ShareWay.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<Reservation> getAll() {
        return reservationService.findAll();
    }

    @GetMapping("/reservations/{id}")
    public Reservation get(@PathVariable Long id) {
        return reservationService.findById(id);
    }

    @PostMapping("/reservatiosn")
    public Reservation create(@RequestBody @Valid Reservation reservation) {
        return reservationService.add(reservation);
    }

    @PutMapping("reservations/{id}")
    public Reservation update(@RequestBody @Valid Reservation reservation, @PathVariable Long id) {
        Reservation updateReservation = reservationService.modify(id, reservation);
        return updateReservation;
    }

    @DeleteMapping("reservations/{id}")
    public void delete(@PathVariable Long id) {
        reservationService.delete(id);
    }
}
