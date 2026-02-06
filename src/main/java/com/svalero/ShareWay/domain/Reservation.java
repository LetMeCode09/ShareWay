package com.svalero.ShareWay.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reservations")

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name= "number_of_seats")
    private int numberOfSeats;
    @Column(name= "reservation_date")
    private LocalDateTime reservationDate;
    @Column
    private Boolean confirmed;
    @Column
    private String comment;
    @Column(name= "total_price")
    private int totalPrice;
}