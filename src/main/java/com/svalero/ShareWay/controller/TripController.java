package com.svalero.ShareWay.controller;

import com.svalero.ShareWay.domain.Trip;
import com.svalero.ShareWay.exception.TripNotFoundException;
import com.svalero.ShareWay.service.TripService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping("/trips")
    public ResponseEntity<List<Trip>> getAll() {
        return new ResponseEntity<>(tripService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/trips/{id}")
    public ResponseEntity<Trip> get(@PathVariable long id) throws TripNotFoundException {
        return new ResponseEntity<>(tripService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/trips")
    public ResponseEntity<Trip> addTrip(@Valid @RequestBody Trip trip) {
        return new ResponseEntity<>(tripService.add(trip), HttpStatus.OK);
    }

    @DeleteMapping("/trips/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable long id) throws TripNotFoundException {
        tripService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}