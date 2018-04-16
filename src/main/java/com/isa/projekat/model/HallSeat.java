package com.isa.projekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HallSeat implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="seat_number", nullable = false)
	private int seatNumber;

	@Column(name="seat_row", nullable = false)
	private int seatRow;
	
	@ManyToOne
	private Hall hall;
	
	@ManyToOne
	private Projection projection;
	
	public HallSeat() {}

	public HallSeat(Long id, int seatNumber, int seatRow, Hall hall, Projection projection) {
		super();
		this.id = id;
		this.seatNumber = seatNumber;
		this.seatRow = seatRow;
		this.hall = hall;
		this.projection = projection;
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

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

	
}
