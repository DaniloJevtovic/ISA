package com.isa.projekat.model;

public class HallDto {

	private Long id;
	private int hallNumber;
	private int hallRows;
	private CinemaTheatreDto cinemaTheatreDto;
	
	public HallDto(Long id, int hallNumber, int hallRows, CinemaTheatreDto cinemaTheatreDto) {
		super();
		this.id = id;
		this.hallNumber = hallNumber;
		this.hallRows = hallRows;
		this.cinemaTheatreDto = cinemaTheatreDto;
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
