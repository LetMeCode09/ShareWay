package com.svalero.ShareWay.controller;

import com.svalero.ShareWay.domain.Reservation;
import com.svalero.ShareWay.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // GET /reservations
    @GetMapping
    public List<Reservation> getAll() {
        return reservationService.findAll();
    }

    // GET /reservations/{id}
    @GetMapping("/{id}")
    public Reservation get(@PathVariable Long id) {
        return reservationService.findById(id);
    }

    // POST /reservations
    @PostMapping
    public Reservation create(@RequestBody @Valid Reservation reservation) {
        return reservationService.add(reservation);
    }

    // PUT /reservations/{id}
    @PutMapping("/{id}")
    public Reservation update(@RequestBody @Valid Reservation reservation, @PathVariable Long id) {
        return reservationService.modify(id, reservation);
    }

    // DELETE /reservations/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reservationService.delete(id);
    }
}
