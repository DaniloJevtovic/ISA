package com.isa.projekat.model;

import java.util.ArrayList;
import java.util.List;

public class ReservationDto {

	private Long id;
	private UserDto userDto;
	private ProjectionTimeDto projectionTimeDto;
	private List<HallSeatDto> hallSeatDtos;
	
	public ReservationDto(Reservation reservation) {
		this.id = reservation.getId();
		this.userDto = new UserDto(reservation.getUser());
		this.projectionTimeDto = new ProjectionTimeDto(reservation.getProjectionTime());
		this.hallSeatDtos = new ArrayList<HallSeatDto>();
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
}
