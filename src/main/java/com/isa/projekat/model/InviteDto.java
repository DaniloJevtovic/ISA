package com.isa.projekat.model;

public class InviteDto {

	private Long id;
	private ReservationDto reservation;
	private UserDto user;
	private HallSeatDto seat;
	private boolean accepted;
	
	public InviteDto(Invite invite) {
		this.id = invite.getId();
		this.reservation = new ReservationDto(invite.getReservation());
		this.user = new UserDto(invite.getUser());
		this.seat = new HallSeatDto(invite.getSeat());
		this.accepted = invite.isAccepted();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReservationDto getReservation() {
		return reservation;
	}

	public void setReservation(ReservationDto reservation) {
		this.reservation = reservation;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public HallSeatDto getSeat() {
		return seat;
	}

	public void setSeat(HallSeatDto seat) {
		this.seat = seat;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	

}
