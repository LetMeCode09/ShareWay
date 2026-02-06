package com.svalero.ShareWay.repository;

import com.svalero.ShareWay.domain.Reservation;
import com.svalero.ShareWay.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
}