package com.isa.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.projekat.model.HallSeat;
import com.isa.projekat.model.HallSeatDto;
import com.isa.projekat.model.ProjectionTime;
import com.isa.projekat.model.ProjectionTimeDto;
import com.isa.projekat.model.Reservation;
import com.isa.projekat.model.ReservationDto;
import com.isa.projekat.model.User;
import com.isa.projekat.service.HallSeatService;
import com.isa.projekat.service.ProjectionTimeService;

@RestController
@RequestMapping("/api/movieshows/{msId}/projections/{projectionId}/projectionTimes")
public class ProjectionTimeController {

	@Autowired
	private ProjectionTimeService projectionTimeService;

	@Autowired
	private HallSeatService hallSeatService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProjectionTimeDto>> getTimesForProjection(@PathVariable Long msId,
			@PathVariable Long projectionId) {
		List<ProjectionTimeDto> projectionTimeDtos = new ArrayList<ProjectionTimeDto>();
		for (ProjectionTime projectionTime : projectionTimeService.findByProjection(projectionId)) {
			projectionTimeDtos.add(new ProjectionTimeDto(projectionTime));
		}
		return new ResponseEntity<List<ProjectionTimeDto>>(projectionTimeDtos, HttpStatus.OK);
	}

	@RequestMapping(value = "/{projectionId}/seats", method = RequestMethod.GET)
	public ResponseEntity<List<HallSeatDto>> getSeatsForProjection(@PathVariable Long projectionId) {
		ProjectionTime projectionTime = projectionTimeService.findOne(projectionId);
		List<HallSeat> hallSeats = hallSeatService.findByHall(projectionTime.getHall().getId());
		List<HallSeatDto> hallSeatDtos = new ArrayList<HallSeatDto>();
		for (HallSeat hallSeat : hallSeats) {
			hallSeatDtos.add(new HallSeatDto(hallSeat));
		}
		return new ResponseEntity<List<HallSeatDto>>(hallSeatDtos, HttpStatus.OK);
	}

	@RequestMapping(value = "/{projectionId}/seats", method = RequestMethod.POST)
	public ResponseEntity<ReservationDto> reserveSeats(@RequestBody List<String> seatInfo,
			@PathVariable Long projectionId, HttpServletRequest request) {
		User loggedUser = (User) request.getSession().getAttribute("loggedUser");
		Reservation reservation = projectionTimeService.reserveSeats(projectionId, seatInfo, loggedUser.getId());

		if (reservation != null) {
			ReservationDto reservationDto = new ReservationDto(reservation);
			return new ResponseEntity<ReservationDto>(reservationDto, HttpStatus.OK);
		}

		ReservationDto reservationDto = null;
		return new ResponseEntity<ReservationDto>(reservationDto, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/{projectionId}/takenSeats", method = RequestMethod.GET)
	public ResponseEntity<List<HallSeatDto>> getTakenSeats(@PathVariable Long projectionId) {
		List<HallSeat> hallSeats = projectionTimeService.getTakenSeats(projectionId);
		List<HallSeatDto> hallSeatDtos = new ArrayList<HallSeatDto>();
		for (HallSeat hallSeat : hallSeats) {
			hallSeatDtos.add(new HallSeatDto(hallSeat));
		}

		return new ResponseEntity<List<HallSeatDto>>(hallSeatDtos, HttpStatus.OK);
	}

}
