package com.isa.projekat.model;

import java.sql.Date;

public class ProjectionTimeDto {

	private Long id;
	private Date date;
	private double price;
	private ProjectionDto projectionDto;
	private HallDto hallDto;
	
	public ProjectionTimeDto(Long id, Date date, double price, ProjectionDto projectionDto, HallDto hallDto) {
		super();
		this.id = id;
		this.date = date;
		this.price = price;
		this.projectionDto = projectionDto;
		this.hallDto = hallDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProjectionDto getProjectionDto() {
		return projectionDto;
	}

	public void setProjectionDto(ProjectionDto projectionDto) {
		this.projectionDto = projectionDto;
	}

	public HallDto getHallDto() {
		return hallDto;
	}

	public void setHallDto(HallDto hallDto) {
		this.hallDto = hallDto;
	}
	
}
