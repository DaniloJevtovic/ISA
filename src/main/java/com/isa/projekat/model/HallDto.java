package com.isa.projekat.model;

public class HallDto {

	private Long id;
	private int hallNumber;
	private int hallRows;
	private int seatsPerRow;
	private CinemaTheatreDto cinemaTheatreDto;

	public HallDto(Hall hall) {
		this.id = hall.getId();
		this.hallNumber = hall.getNumber();
		this.hallRows = hall.getRows();
		this.seatsPerRow = hall.getSeatsPerRow();
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

	public int getSeatsPerRow() {
		return seatsPerRow;
	}

	public void setSeatsPerRow(int seatsPerRow) {
		this.seatsPerRow = seatsPerRow;
	}
}
