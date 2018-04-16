package com.isa.projekat.model;

public class HallDto {

	private Long id;
	private int hallNumber;
	private int hallRows;
	private CinemaTheatreDto cinemaTheatreDto;
	
	public HallDto(Hall hall) {
		this.id = hall.getId();
		this.hallNumber = hall.getHallNumber();
		this.hallRows = hall.getHallRows();
		this.cinemaTheatreDto = new CinemaTheatreDto(hall.getCinemaTheatre());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getHallNumber() {
		return hallNumber;
	}

	public void setHallNumber(int hallNumber) {
		this.hallNumber = hallNumber;
	}

	public int getHallRows() {
		return hallRows;
	}

	public void setHallRows(int hallRows) {
		this.hallRows = hallRows;
	}

	public CinemaTheatreDto getCinemaTheatreDto() {
		return cinemaTheatreDto;
	}

	public void setCinemaTheatreDto(CinemaTheatreDto cinemaTheatreDto) {
		this.cinemaTheatreDto = cinemaTheatreDto;
	}
}
