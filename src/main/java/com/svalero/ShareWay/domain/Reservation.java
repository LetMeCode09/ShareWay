package com.svalero.ShareWay.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @Min(value=1)
    @NotNull
    @Column(name= "number_of_seats")
    private int numberOfSeats;
    @NotNull(message = "date is required")
    @Column(name= "reservation_date")
    private LocalDateTime reservationDate;
    @Column
    private Boolean confirmed;
    @Max(value= 80)
    @Column
    private String comment;
    @Min(value = 0, message = "price cannot be negative")
    @Column(name= "total_price")
    private int totalPrice;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnoreProperties("reservations")
    private User user;

    @ManyToOne
    @JoinColumn(name="trip_id")
    @JsonIgnoreProperties("reservations")
    private Trip trip;
}