package com.svalero.ShareWay.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Origin is mandatory")
    @Column
    private String origin;
    @NotNull(message = "Destination is mandatory")
    @Column
    private String destination;
    @NotNull(message = "Date and time are mandatory")
    @Column(name= "date_time")
    private LocalDateTime dateTime;
    @Column(name= "transport_types")
    private String transportTypes;
    @Min(value=1)
    @Column(name= "available_seats")
    private int availableSeats;
    @Min(value = 0, message = "price cannot be negative")
    @Column(name= "prices")
    private int price;
    @Column
    private Boolean full;

    @OneToMany (mappedBy = "trip")
    private List<Reservation> reservation;
}