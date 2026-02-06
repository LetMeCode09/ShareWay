package com.svalero.ShareWay.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Email(message = "email format is not valid")
    @Column(unique = true)
    private String email;
    @Column
    private String phone;
    @NotNull(message = "reservationDate is mandatory")
    @Column(name = "registration_date")
    private LocalDate registrationDate;
    @Column(name = "number_of_reservations")
    private int numberOfReservations;
    @Column
    private Boolean verified;
}
