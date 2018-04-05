package com.isa.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.projekat.model.User;
import com.isa.projekat.model.UserDto;
import com.isa.projekat.service.UserService;


@RestController
@RequestMapping("/api/users")
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/register",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<UserDto> registerUser(@RequestBody User user) throws Exception{
		userService.save(user);
		User savedUser = userService.findByEmail(user.getEmail());
		userService.sendVerificationMail(savedUser);
		UserDto userdto = new UserDto(user);
		return new ResponseEntity<UserDto>(userdto, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/verify/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> verifyUser(@PathVariable Long id) throws Exception{
		userService.verifyEmail(id);
		return new ResponseEntity<String>("Uspjesno ste verifikovani!", HttpStatus.ACCEPTED);
	}
}
