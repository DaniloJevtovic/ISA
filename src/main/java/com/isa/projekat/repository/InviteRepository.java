package com.isa.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.projekat.model.Invite;
import com.isa.projekat.model.Reservation;

public interface InviteRepository extends JpaRepository<Invite, Long> {

	List<Invite> findByReservation(Reservation reservation);
}
