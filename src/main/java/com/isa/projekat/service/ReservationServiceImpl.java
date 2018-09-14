package com.isa.projekat.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.isa.projekat.model.Invite;
import com.isa.projekat.model.ProjectionTime;
import com.isa.projekat.model.Reservation;
import com.isa.projekat.model.User;
import com.isa.projekat.repository.InviteRepository;
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
	
	@Autowired
	private InviteRepository invRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment environment;

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
		Hibernate.initialize(reservation.getInvites());
		reservation.getInvites().clear();
		List<Invite> invites = invRepository.findByReservation(reservation);
		invRepository.delete(invites);
		projectionTime.getHallSeats().removeAll(reservation.getHallSeats());
		user.getReservations().remove(reservation);
		userRepository.save(user);
		reservationRepository.delete(resId);
		projectionTimeRepository.save(projectionTime);

		return reservation;
	}

	@Override
	public void sendReservationMail(Long userId, Long reservationId) {
		// TODO Auto-generated method stub
		User user = userRepository.findOne(userId);
		Reservation reservation = reservationRepository.findOne(reservationId);
		SimpleMailMessage mail = new SimpleMailMessage();
		Hibernate.initialize(reservation.getHallSeats());
		mail.setTo(user.getEmail());
		mail.setFrom(environment.getProperty("spring.mail.username"));
		mail.setSubject("Podaci o rezervaciji");
		mail.setText("Poštovani " + user.getName() +"," 
				+"\npodaci o Vašoj rezervaciji su sledeći: " 
				+"\n\nNaiv: " +reservation.getProjectionTime().getProjection().getMovieShow().getName()
				+"\nTrajanje: " +reservation.getProjectionTime().getProjection().getMovieShow().getDuration() +"h"
				+"\nDatum projekcije: "+reservation.getProjectionTime().getProjection().getDate() 
				+"\nVrijeme projekcije: "+reservation.getProjectionTime().getTime() +"h"
				+"\nBioskop/Pozoriste: "+reservation.getProjectionTime().getProjection().getMovieShow().getCinemaTheatre().getName()
				+"\nAdresa: "+reservation.getProjectionTime().getProjection().getMovieShow().getCinemaTheatre().getAdress()
				+"\nSala: " +reservation.getProjectionTime().getHall().getNumber()		
				//+"\nSjedište: " +reservation.getProjectionTime().getHallSeats()
				+"\n\nRezervaciju je moguće otkazati najkasnije 30 minuta prije početka projekcije!");
		javaMailSender.send(mail);
	}

}
