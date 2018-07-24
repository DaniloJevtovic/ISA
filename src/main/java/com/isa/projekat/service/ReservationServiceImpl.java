package com.isa.projekat.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.projekat.model.ProjectionTime;
import com.isa.projekat.model.Reservation;
import com.isa.projekat.model.User;
import com.isa.projekat.repository.ProjectionTimeRepository;
import com.isa.projekat.repository.ReservationRepository;
import com.isa.projekat.repository.UserRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProjectionTimeRepository projectionTimeRepository;

	@Override
	public Reservation save(Reservation reservation) {
		// TODO Auto-generated method stub
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation getReservation(Long resId) {
		// TODO Auto-generated method stub
		return reservationRepository.findOne(resId);
	}

	@Override
	public List<Reservation> getAllReservations() {
		// TODO Auto-generated method stub
		return reservationRepository.findAll();
	}

	@Override
	public List<Reservation> getUserReservation(Long userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findOne(userId);
		return reservationRepository.findByUser(user);
	}

	@Override
	public List<Reservation> getUserVisitHistory(Long userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId);
		return reservationRepository.findByUserAndVisited(user, true);
	}

	@Override
	public Reservation cancelReservation(Long resId) {
		// TODO Auto-generated method stub
		Reservation reservation = reservationRepository.findOne(resId);
		ProjectionTime projectionTime = reservation.getProjectionTime();
		User user = userRepository.findOne(reservation.getUser().getId());
		Hibernate.initialize(user.getReservations());
		Hibernate.initialize(reservation.getHallSeats());
		Hibernate.initialize(projectionTime.getHallSeats());
		projectionTime.getHallSeats().removeAll(reservation.getHallSeats());
		user.getReservations().remove(reservation);
		userRepository.save(user);
		reservationRepository.delete(resId);
		projectionTimeRepository.save(projectionTime);

		return reservation;
	}

}
