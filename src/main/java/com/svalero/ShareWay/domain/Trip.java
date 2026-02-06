

package com.svalero.ShareWay.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String origin;
    @Column
    private String destination;
    @Column(name= "date_time")
    private LocalDateTime dateTime;
    @Column(name= "transport_type")
    private String transportType;
    @Column(name= "available_seats")
    private int availableSeats;
    @Column
    private int price;
    @Column
    private Boolean full;
}

