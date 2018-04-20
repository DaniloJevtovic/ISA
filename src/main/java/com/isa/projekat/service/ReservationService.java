package com.isa.projekat.service;

import java.util.List;

import com.isa.projekat.model.Reservation;

public interface ReservationService {

	Reservation save(Reservation reservation);

	Reservation getReservation(Long resId);
	
	List<Reservation> getAllReservations();

	List<Reservation> getUserReservation(Long userId);

	List<Reservation> getUserVisitHistory(Long userId);

	
}
