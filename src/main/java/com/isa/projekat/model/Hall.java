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
	
	@Column(name="hall_number", nullable = false)
	private int hallNumber;
	
	@Column(name="hall_rows", nullable = false)
	private int hallRows;
	
	@ManyToOne(targetEntity = CinemaTheatre.class)
	private CinemaTheatre cinemaTheatre;
	
	@OneToMany(targetEntity = HallSeat.class)
	private List<HallSeat> hallSeats;

	public Hall() {}
	
	public Hall(Long id, int hallNumber, int hallRows, CinemaTheatre cinemaTheatre, List<HallSeat> hallSeats) {
		super();
		this.id = id;
		this.hallNumber = hallNumber;
		this.hallRows = hallRows;
		this.cinemaTheatre = cinemaTheatre;
		this.hallSeats = hallSeats;
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
