package com.svalero.ShareWay.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (nullable = false)
    @NotBlank(message = "name is mandatory")
    private String name;
    @Email(message = "email format is not valid")
    @NotBlank(message = "email is mandatory")
    @Column(unique = true)
    private String email;
    @Column
    @NotBlank(message = "phone is mandatory")
    @Pattern(regexp = "^\\d+$", message = "phone must be numbers")
    @Size(min = 9, message = "phone must have at least 9 numbers")
    private String phone;
    @NotNull(message = "reservationDate is mandatory")
    @Column(name = "registration_date")
    private LocalDate registrationDate;
    @Column(name = "stars")
    @Min(value = 0,message = "Min 0")
    @Max(value= 5,message = "Max 5")
    private int star;
    @Column
    private Boolean verified;

    @JsonIgnoreProperties("user")
    @OneToMany (mappedBy = "user")
    private List <Reservation> reservation;
}