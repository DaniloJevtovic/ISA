package com.isa.projekat.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.isa.projekat.model.HallSeat;
import com.isa.projekat.model.Invite;
import com.isa.projekat.model.ProjectionTime;
import com.isa.projekat.model.Reservation;
import com.isa.projekat.model.User;
import com.isa.projekat.repository.InviteRepository;
import com.isa.projekat.repository.ReservationRepository;
import com.isa.projekat.repository.UserRepository;

@Service
public class InviteServiceImpl implements InviteService {

	@Autowired
	private ReservationRepository resRepository;

	@Autowired
	private InviteRepository invRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Environment environment;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public Invite save(Invite invite) {
		// TODO Auto-generated method stub
		return invRepository.save(invite);
	}

	@Override
	public Invite sendInvite(Long reservationId, Long userId) {
		// TODO Auto-generated method stub
		Reservation reservation = resRepository.findOne(reservationId);
		User receiver = userRepository.findOne(userId);
		Hibernate.initialize(reservation.getHallSeats());
		Hibernate.initialize(reservation.getInvites());
		List<HallSeat> seats = new ArrayList<HallSeat>();
		List<Invite> invites = new ArrayList<Invite>();

		invites = generateInvitesClone(reservationId);
		seats = generateSeatsClone(reservationId);

		for (int i = 0; i < invites.size(); i++) {
			if (seats.contains(invites.get(i).getSeat())) {
				seats.remove(invites.get(i).getSeat());
			}
		}
		if (seats.size() > 0) {
			Invite invite = new Invite(receiver, reservation, seats.get(0), false);
			invRepository.save(invite);
			Hibernate.initialize(reservation.getInvites());
			reservation.getInvites().add(invite);
			resRepository.save(reservation);
			return invite;
		}

		return null;
	}

	@Override
	public Invite acceptInvite(Long inviteId) {
		// TODO Auto-generated method stub
		Invite invite = invRepository.findOne(inviteId);
		invite.setAccepted(true);
		invRepository.save(invite);
		return invite;
	}

	@Override
	public Invite declineInvite(Long inviteId) {
		// TODO Auto-generated method stub
		Invite invite = invRepository.findOne(inviteId);
		Reservation reservation = invite.getReservation();
		ProjectionTime prjTime = reservation.getProjectionTime();
		prjTime.getHallSeats().remove(invite.getSeat());
		reservation.getHallSeats().remove(invite.getSeat());
		reservation.getInvites().remove(invite);
		reservation.setPrice(reservation.getHallSeats().size() * prjTime.getPrice());
		invRepository.delete(inviteId);
		return invite;
	}

	@Override
	public Invite findOne(Long inviteId) {
		// TODO Auto-generated method stub
		return invRepository.findOne(inviteId);
	}

	@Override
	public void sendInviteEmail(Long userId, Long inviteId) {
		// TODO Auto-generated method stub
		User user = userRepository.findOne(userId);
		Invite invite = invRepository.findOne(inviteId);
		Reservation reservation = invite.getReservation();
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getEmail());
		mailMessage.setFrom(environment.getProperty("spring.mail.username"));
		mailMessage.setSubject("Poziv za projekciju");
		mailMessage.setText(
				"Poštovani " + user.getName() + ",\n\n" + reservation.getUser().getName() + " "
				+ reservation.getUser().getSurname() + " Vam šalje pozivnicu za projekciju: " 
				+ reservation.getProjectionTime().getProjection().getMovieShow().getName()
				+"\nDana: " + reservation.getProjectionTime().getProjection().getDate()
				+" u " +reservation.getProjectionTime().getTime() +"h."
				
				+ "\n\nLink za potvrdu je sledeci: " + " http://localhost:1111/api/invites/" + invite.getId() + "/accept" 
				+ "\nLink za otkazivanje je sledeci: " + " http://localhost:1111/api/invites/" + invite.getId() + "/decline");
		
		javaMailSender.send(mailMessage);
	}

	public List<Invite> generateInvitesClone(Long reservationId) {
		Reservation reservation = resRepository.findOne(reservationId);
		Hibernate.initialize(reservation.getInvites());
		List<Invite> invites = new ArrayList<Invite>();
		for (int i = 0; i < reservation.getInvites().size(); i++) {
			invites.add(reservation.getInvites().get(i));
		}
		return invites;
	}

	public List<HallSeat> generateSeatsClone(Long reservationId) {
		Reservation reservation = resRepository.findOne(reservationId);
		Hibernate.initialize(reservation.getHallSeats());
		List<HallSeat> seats = new ArrayList<HallSeat>();
		for (int i = 0; i < reservation.getHallSeats().size(); i++) {
			seats.add(reservation.getHallSeats().get(i));
		}
		return seats;
	}

}
