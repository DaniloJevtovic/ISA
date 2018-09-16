package com.isa.projekat.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
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
		return reservationRepository.findByUserAndVisited(user, false);
	}

	@Override
	public List<Reservation> getUserVisitHistory(Long userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId);
		return reservationRepository.findByUserAndVisited(user, true);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Reservation cancelReservation(Long resId) {
		// TODO Auto-generated method stub
		Date date = new Date();
		boolean flag = false;
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		Calendar calendar3 = Calendar.getInstance();
		calendar1.setTime(date);
		java.sql.Date sqlDateNow = new java.sql.Date(date.getTime());

		Reservation reservation = reservationRepository.findOne(resId);

		java.sql.Date sqlDatePrjDate = new java.sql.Date(reservation.getProjectionTime().getProjection().getDate().getTime());
		java.sql.Date sqlDatePrjTime = new java.sql.Date(reservation.getProjectionTime().getTime().getTime());

		calendar2.setTime(sqlDatePrjTime);
		calendar3.setTime(sqlDatePrjDate);

		if (sqlDatePrjDate.compareTo(sqlDateNow) >= 0 || calendarCompareSameDate(calendar1, calendar3) == true) {
			calendar2.add(Calendar.MINUTE, -30);
			if (calendarCompareSameDate(calendar1, calendar3) == true) {
				if (calendar1.get(Calendar.HOUR_OF_DAY) > calendar2.get(Calendar.HOUR_OF_DAY)) {
					flag = true;
				} else if (calendar2.get(Calendar.HOUR_OF_DAY) == calendar1.get(Calendar.HOUR_OF_DAY)) {
					if (calendar2.get(Calendar.MINUTE) < calendar1.get(Calendar.MINUTE)) {
						flag = true;
					}
				}
			}
		} else {
			flag = true;
		}

		if (!flag) {
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
		} else {
			return null;
		}

	}

	@Override
	@Async
	@Transactional
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

	@Override
	@Scheduled(cron = "*/10 * * * * *")
	public void isVisited() {
		// TODO Auto-generated method stub
		Date date = new Date();
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		Calendar calendar3 = Calendar.getInstance();
		calendar1.setTime(date);
		List<Reservation> reservations = reservationRepository.findAll();
		for (Reservation res : reservations) {
			boolean flag = false;
			calendar2.setTime(res.getProjectionTime().getProjection().getDate());
			calendar3.setTime(res.getProjectionTime().getTime());
			calendar3.add(Calendar.MINUTE, -30);
			if (res.isVisited() == false && (calendar1.after(calendar2) || calendarCompareSameDate(calendar1, calendar2))) {
				if (calendar3.get(Calendar.HOUR_OF_DAY) == calendar1.get(Calendar.HOUR_OF_DAY)) {
					if (calendar3.get(Calendar.MINUTE) < calendar1.get(Calendar.MINUTE)) {
						flag = true;
					}
				} else {
					flag = true;
				}
			}
			if (flag) {
				res.setVisited(true);
				// oslobodi mjesta!!!
				reservationRepository.save(res);
			}
		}
	}
	
	public boolean calendarCompareSameDate(Calendar c1, Calendar c2) {
		if(c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) && c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR)) {
			return true;
		}
		return false;
	}

}
