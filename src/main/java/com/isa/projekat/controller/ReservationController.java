package com.isa.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.projekat.model.Invite;
import com.isa.projekat.model.InviteDto;
import com.isa.projekat.model.Reservation;
import com.isa.projekat.model.ReservationDto;
import com.isa.projekat.model.User;
import com.isa.projekat.service.InviteService;
import com.isa.projekat.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private InviteService inviteService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ReservationDto>> getAll() {
		List<Reservation> reservations = reservationService.getAllReservations();
		List<ReservationDto> reservationDtos = new ArrayList<ReservationDto>();
		for (Reservation reservation : reservations) {
			reservationDtos.add(new ReservationDto(reservation));
		}
		return new ResponseEntity<List<ReservationDto>>(reservationDtos, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllForLogged", method = RequestMethod.GET)
	public ResponseEntity<List<ReservationDto>> getReservationsforLoggedUser(HttpServletRequest request) {
		User logged = (User) request.getSession().getAttribute("loggedUser");
		List<Reservation> reservations = reservationService.getUserReservation(logged.getId());
		List<ReservationDto> reservationDtos = new ArrayList<ReservationDto>();
		for (Reservation reservation : reservations) {
			reservationDtos.add(new ReservationDto(reservation));
		}
		return new ResponseEntity<List<ReservationDto>>(reservationDtos, HttpStatus.OK);
	}

	@RequestMapping(value = "/getVisitsForLogged", method = RequestMethod.GET)
	public ResponseEntity<List<ReservationDto>> getVisitsforLoggedUser(HttpServletRequest request) {
		User logged = (User) request.getSession().getAttribute("loggedUser");
		List<Reservation> reservations = reservationService.getUserVisitHistory(logged.getId());
		List<ReservationDto> reservationDtos = new ArrayList<ReservationDto>();
		for (Reservation reservation : reservations) {
			reservationDtos.add(new ReservationDto(reservation));
		}
		return new ResponseEntity<List<ReservationDto>>(reservationDtos, HttpStatus.OK);
	}

	@RequestMapping(value = "/{resId}", method = RequestMethod.GET)
	public ResponseEntity<ReservationDto> getReservation(@PathVariable Long resId) {
		Reservation reservation = reservationService.getReservation(resId);
		ReservationDto reservationDto = new ReservationDto(reservation);
		return new ResponseEntity<ReservationDto>(reservationDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/cancel/{resId}", method = RequestMethod.DELETE)
	public ResponseEntity<ReservationDto> cancelReservation(@PathVariable Long resId) {
		Reservation deleted = reservationService.cancelReservation(resId);
		if (deleted != null) {
			ReservationDto deletedDto = new ReservationDto(deleted);
			return new ResponseEntity<ReservationDto>(deletedDto, HttpStatus.OK);
		} else {
			ReservationDto reservationDto = null;
			return new ResponseEntity<ReservationDto>(reservationDto, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/{resId}/sendInvite/{userId}", method = RequestMethod.GET)
	public ResponseEntity<InviteDto> sendInvite(@PathVariable Long resId, @PathVariable Long userId) {
		Invite inv = inviteService.sendInvite(resId, userId);
		InviteDto inviteDto = new InviteDto(inv);
		inviteService.sendInviteEmail(userId, inv.getId());
		return new ResponseEntity<InviteDto>(inviteDto, HttpStatus.OK);
	}

}
