package com.isa.projekat.model;

public class HallSeatDto {
	
	private Long id;
	private int seatNumber;
	private int seatRow;
	private HallDto hallDto;
	private ProjectionDto projectionDto;
	
	public HallSeatDto(HallSeat hallSeat) {
		// TODO Auto-generated constructor stub
		this.id = hallSeat.getId();
		this.seatNumber = hallSeat.getSeatNumber();
		this.seatRow = hallSeat.getSeatRow();
		this.hallDto = new HallDto(hallSeat.getHall());
		this.projectionDto = new ProjectionDto(hallSeat.getProjection());
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

	public ProjectionDto getProjectionDto() {
		return projectionDto;
	}

	public void setProjectionDto(ProjectionDto projectionDto) {
		this.projectionDto = projectionDto;
	}
		
	
}