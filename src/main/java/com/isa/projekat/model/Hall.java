package com.isa.projekat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Hall implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "hall_number", nullable = false)
	private int number;

	@Column(name = "hall_rows", nullable = false)
	private int rows;

	@Column(name = "hall_seatrows", nullable = false)
	private int seatsPerRow;

	@ManyToOne(targetEntity = CinemaTheatre.class)
	private CinemaTheatre cinemaTheatre;

	@OneToMany(targetEntity = HallSeat.class)
	private List<HallSeat> hallSeats;

	public Hall() {}

	public Hall(Long id, int number, int rows, int seatsPerRow, CinemaTheatre cinemaTheatre, List<HallSeat> hallSeats) {
		super();
		this.id = id;
		this.number = number;
		this.rows = rows;
		this.seatsPerRow = seatsPerRow;
		this.cinemaTheatre = cinemaTheatre;
		this.hallSeats = hallSeats;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getSeatsPerRow() {
		return seatsPerRow;
	}

	public void setSeatsPerRow(int seatsPerRow) {
		this.seatsPerRow = seatsPerRow;
	}

	public CinemaTheatre getCinemaTheatre() {
		return cinemaTheatre;
	}

	public void setCinemaTheatre(CinemaTheatre cinemaTheatre) {
		this.cinemaTheatre = cinemaTheatre;
	}

	public List<HallSeat> getHallSeats() {
		return hallSeats;
	}

	public void setHallSeats(List<HallSeat> hallSeats) {
		this.hallSeats = hallSeats;
	}

}
