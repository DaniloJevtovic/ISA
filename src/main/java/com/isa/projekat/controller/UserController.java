package com.isa.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> login(@RequestBody User user, HttpSession session, HttpServletRequest request) {
		User loggedUser = userService.login(user);
		if (loggedUser != null) {
			HttpSession newSession = request.getSession();
			newSession.setAttribute("loggedUser", loggedUser);
			UserDto logged = new UserDto(loggedUser);
			return new ResponseEntity<UserDto>(logged, HttpStatus.OK);
		}
		UserDto logged = null;
		return new ResponseEntity<UserDto>(logged, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<String> logout(HttpSession session, HttpServletRequest request) {
		request.getSession().invalidate();
		return new ResponseEntity<String>("Korisnik izlogovan", HttpStatus.OK);
	}

	@RequestMapping(value = "/isLoggedIn", method = RequestMethod.GET)
	public ResponseEntity<UserDto> getLoggedIn(HttpServletRequest request) {
		User logged = (User) request.getSession().getAttribute("loggedUser");
		if (logged != null) {
			UserDto loggedDTO = new UserDto(logged);
			return new ResponseEntity<UserDto>(loggedDTO, HttpStatus.OK);
		}
		UserDto loggedDTO = null;
		return new ResponseEntity<UserDto>(loggedDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> registerUser(@RequestBody User user) throws Exception {
		User registerUser = userService.save(user);

		if (registerUser != null) {
			User savedUser = userService.findByEmail(user.getEmail());
			userService.sendVerificationMail(savedUser);
			UserDto userdto = new UserDto(user);
			return new ResponseEntity<UserDto>(userdto, HttpStatus.CREATED);
		}

		UserDto userDto = null;
		return new ResponseEntity<UserDto>(userDto, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/verify/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> verifyUser(@PathVariable Long id) throws Exception {
		userService.verifyEmail(id);
		return new ResponseEntity<String>("Uspjesno ste verifikovani!", HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserDto> editedUser(@RequestBody User user, @PathVariable Long id) {
		User editedUser = userService.editUser(user, id);
		return new ResponseEntity<UserDto>(new UserDto(editedUser), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>> getUsers() {
		List<User> users = userService.findAll();
		List<UserDto> usersdto = new ArrayList<UserDto>();
		for (User user : users) {
			usersdto.add(new UserDto(user));
		}
		return new ResponseEntity<List<UserDto>>(usersdto, HttpStatus.FOUND);
	}

}
