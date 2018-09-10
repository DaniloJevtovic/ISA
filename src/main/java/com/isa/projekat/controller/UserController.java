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

	@RequestMapping(value = "/sendFriendRequest/{reciverId}", method = RequestMethod.GET)
	public ResponseEntity<String> sendFriendRequest(@PathVariable Long reciverId, HttpServletRequest request) {
		User senderRequest = (User) request.getSession().getAttribute("loggedUser");
		User reciverRequest = userService.sendFriendRequest(senderRequest.getId(), reciverId);

		if (reciverRequest != null) {
			return new ResponseEntity<String>("friends request sent", HttpStatus.ACCEPTED);
		}

		else {
			return new ResponseEntity<String>("alredy sent", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/approveFriendRequest/{sender}", method = RequestMethod.GET)
	public ResponseEntity<String> approveFriendRequest(@PathVariable Long sender, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("loggedUser");
		userService.approveFriendRequest(sender, user.getId());
		return new ResponseEntity<String>("request approved", HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/declineFriendRequest/{pendingId}", method=RequestMethod.GET)
	public ResponseEntity<UserDto> declineFriendRequest(@PathVariable Long pendingId,HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("loggedUser");
		if(user != null) {
			User deleted = userService.declineFriendRequest(pendingId, user.getId());
			UserDto deletedDto = new UserDto(deleted);
			return new ResponseEntity<UserDto>(deletedDto, HttpStatus.OK);
		}
		UserDto deldto = null;
		return new ResponseEntity<UserDto>(deldto, HttpStatus.BAD_GATEWAY);
	}
	
	@RequestMapping(value = "/getFriends/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>> getFriends(@PathVariable Long id) {
		List<User> friends = userService.getFriends(id);
		List<UserDto> friendsDto = new ArrayList<UserDto>();
		
		for(User friend : friends) {
			friendsDto.add(new UserDto(friend));
		}
		
		return new ResponseEntity<List<UserDto>>(friendsDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getFriendRequests/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>> getFriendRequests(@PathVariable Long id) {
		List<User> requests = userService.getFriendRequests(id);
		List<UserDto> requestDto = new ArrayList<UserDto>();
		
		for(User friend : requests) {
			requestDto.add(new UserDto(friend));
		}
		
		return new ResponseEntity<List<UserDto>>(requestDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/removeFriend/{friendId}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> removeFriend(@PathVariable Long friendId, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("loggedUser");
		User friend = userService.removeFriend(user.getId(), friendId);
		UserDto friendDto = new UserDto(friend);
		return new ResponseEntity<UserDto>(friendDto, HttpStatus.OK);
	}

	
	@RequestMapping(value="/search/{name}/{surname}")
	public ResponseEntity<List<UserDto>> searchUsers(@PathVariable String name, @PathVariable String surname){
		List<User> searched = userService.searchUsers(name, surname);
		List<UserDto> searcheddto = new ArrayList<UserDto>();
		for(User user : searched) {
			searcheddto.add(new UserDto(user));
		}
		if(searched.size() != 0) {
			return new ResponseEntity<List<UserDto>>(searcheddto,HttpStatus.OK);
		}else {
			return new ResponseEntity<List<UserDto>>(searcheddto,HttpStatus.NOT_FOUND);
		}
	}
	
	
}
