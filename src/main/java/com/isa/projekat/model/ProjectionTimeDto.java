package com.isa.projekat.model;

import java.util.Date;

public class ProjectionTimeDto {

	private Long id;
	private Date time;
	private double price;
	private HallDto hallDto;
	private ProjectionDto projectionDto;

	public ProjectionTimeDto(ProjectionTime pt) {
		super();
		this.id = pt.getId();
		this.time = pt.getTime();
		this.price = pt.getPrice();
		this.hallDto = new HallDto(pt.getHall());
		this.projectionDto = new ProjectionDto(pt.getProjection());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
