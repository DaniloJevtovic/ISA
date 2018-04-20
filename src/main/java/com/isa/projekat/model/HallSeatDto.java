package com.isa.projekat.model;

public class HallSeatDto {

	private Long id;
	private int seatNumber;
	private int seatRow;
	private HallDto hallDto;

	public HallSeatDto(HallSeat hallSeat) {
		// TODO Auto-generated constructor stub
		this.id = hallSeat.getId();
		this.seatNumber = hallSeat.getNumber();
		this.seatRow = hallSeat.getRow();
		this.hallDto = new HallDto(hallSeat.getHall());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(int seatRow) {
		this.seatRow = seatRow;
	}

	public HallDto getHallDto() {
		return hallDto;
	}

	public void setHallDto(HallDto hallDto) {
		this.hallDto = hallDto;
	}

}
