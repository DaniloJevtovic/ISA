package com.isa.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.projekat.model.Reservation;
import com.isa.projekat.model.User;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	List<Repository> findByUser(User user);
}
