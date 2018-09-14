package com.isa.projekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Invite implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Reservation reservation;
	
	@ManyToOne
	private User user;
	
	@OneToOne
	private HallSeat seat;
	
	@Column
	private boolean accepted;
	
	public Invite() {
		// TODO Auto-generated constructor stub
	}

	public Invite(User user, Reservation reservation,  HallSeat seat, boolean accepted) {
		super();
		this.user = user;
		this.reservation = reservation;
		this.seat = seat;
		this.accepted = accepted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HallSeat getSeat() {
		return seat;
	}

	public void setSeat(HallSeat seat) {
		this.seat = seat;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

}
