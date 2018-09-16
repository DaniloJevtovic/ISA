package com.isa.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.projekat.model.Invite;
import com.isa.projekat.model.InviteDto;
import com.isa.projekat.service.InviteService;

@RestController
@RequestMapping("/api/invites")
public class InviteController {

	@Autowired
	private InviteService inviteService;

	@RequestMapping(value = "/{invId}/accept", method = RequestMethod.GET)
	public ResponseEntity<String> acceptInvite(@PathVariable Long invId) {
		Invite invite = inviteService.acceptInvite(invId);
		InviteDto inviteDto = new InviteDto(invite);
		if (inviteDto.getId() != null) {
			return new ResponseEntity<String>("uspjesno ste prihvatili zahtjev za projekciju", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("greska", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/{invId}/decline", method = RequestMethod.GET)
	public ResponseEntity<String> declineInvite(@PathVariable Long invId) {
		Invite inv = inviteService.declineInvite(invId);
		InviteDto inviteDto = new InviteDto(inv);
		if (inviteDto.getId() != null) {
			return new ResponseEntity<String>("zahtjev odbijen", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("greska", HttpStatus.BAD_REQUEST);
		}
	}

}
