package com.isa.projekat.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;

public class ReservationDto {

	private Long id;
	private UserDto userDto;
	private ProjectionTimeDto projectionTimeDto;
	private List<HallSeatDto> hallSeatDtos;
	private double price;
	private boolean visited;

	public ReservationDto(Reservation reservation) {
		super();
		this.id = reservation.getId();
		this.userDto = new UserDto(reservation.getUser());
		this.projectionTimeDto = new ProjectionTimeDto(reservation.getProjectionTime());
		this.hallSeatDtos = new ArrayList<HallSeatDto>();
		Hibernate.initialize(reservation.getHallSeats());
		for (int i = 0; i < reservation.getHallSeats().size(); i++) {
			this.hallSeatDtos.add(new HallSeatDto(reservation.getHallSeats().get(i)));
		}
		this.price = reservation.getPrice();
		this.visited = reservation.isVisited();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public ProjectionTimeDto getProjectionTimeDto() {
		return projectionTimeDto;
	}

	public void setProjectionTimeDto(ProjectionTimeDto projectionTimeDto) {
		this.projectionTimeDto = projectionTimeDto;
	}

	public List<HallSeatDto> getHallSeatDtos() {
		return hallSeatDtos;
	}

	public void setHallSeatDtos(List<HallSeatDto> hallSeatDtos) {
		this.hallSeatDtos = hallSeatDtos;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}
