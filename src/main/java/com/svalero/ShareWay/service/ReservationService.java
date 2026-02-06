package com.svalero.ShareWay.service;

import com.svalero.ShareWay.domain.Reservation;
import com.svalero.ShareWay.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ReservationService {

    public ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> findAll() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }

    public Reservation add(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation modify(Long id, Reservation reservation) {
        Reservation updatedReservation = reservationRepository.findById(id).orElse(null);
        if (updatedReservation != null) {
            updatedReservation.setReservationDate(reservation.getReservationDate());
            updatedReservation.setConfirmed(reservation.getConfirmed());
            updatedReservation.setTrip(reservation.getTrip());
            updatedReservation.setTotalPrice(reservation.getTotalPrice());
            updatedReservation.setNumberOfSeats(reservation.getNumberOfSeats());
        }
        return reservationRepository.save(updatedReservation);
    }

    public void delete(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                        .orElse(null);
        reservationRepository.delete(reservation);

    }



}
