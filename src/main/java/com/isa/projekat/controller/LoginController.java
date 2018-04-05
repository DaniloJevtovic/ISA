package com.isa.projekat.controller;

import com.isa.projekat.service.UserService;

import com.isa.projekat.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class LoginController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> login(@RequestBody User user,HttpSession session,HttpServletRequest request){
		User loggedUser = userService.login(user);
		if(loggedUser != null) {
		    HttpSession newSession = request.getSession();
		    newSession.setAttribute("loggedUser", loggedUser);
		    UserDto logged = new UserDto(loggedUser);
		    return new ResponseEntity<UserDto>(logged,HttpStatus.OK);
		}
		UserDto logged = null;
		return new ResponseEntity<UserDto>(logged, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public ResponseEntity<String> logout(HttpSession session, HttpServletRequest request){
		request.getSession().invalidate();
		return new ResponseEntity<String>("Korisnik izlogovan",HttpStatus.OK);
	}
	
	@RequestMapping(value="/isLoggedIn",method = RequestMethod.GET)
	public ResponseEntity<UserDto> getLoggedIn(HttpServletRequest request){
		User logged = (User) request.getSession().getAttribute("loggedUser");
		if(logged != null) {
			UserDto loggedDTO = new UserDto(logged);
			return new ResponseEntity<UserDto>(loggedDTO,HttpStatus.OK);
		}
		UserDto loggedDTO = null;
		return new ResponseEntity<UserDto>(loggedDTO,HttpStatus.OK);
	}

}
