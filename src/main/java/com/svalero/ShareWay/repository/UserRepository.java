package com.svalero.ShareWay.repository;

import com.svalero.ShareWay.domain.Reservation;
import com.svalero.ShareWay.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}