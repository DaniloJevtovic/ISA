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

	@Column(name = "seat_row", nullable = false)
	private int row;		//broj reda

	@Column(name = "seat_number", nullable = false)
	private int number;		//broj sjedista u redu

	@ManyToOne
	private Hall hall;

	public HallSeat() {
	}

	public HallSeat(Long id, int number, int row, Hall hall) {
		super();
		this.id = id;
		this.number = number;
		this.row = row;
		this.hall = hall;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getNumber() {
		return number;
	}

	public void setSeatNumber(int number) {
		this.number = number;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

}
