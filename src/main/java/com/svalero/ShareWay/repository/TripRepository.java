package com.svalero.ShareWay.repository;

import com.svalero.ShareWay.domain.Reservation;
import com.svalero.ShareWay.domain.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {

}