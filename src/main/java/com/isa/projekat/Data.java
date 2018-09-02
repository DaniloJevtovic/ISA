package com.isa.projekat;

import java.text.ParseException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isa.projekat.model.User;
import com.isa.projekat.model.UserType;

import com.isa.projekat.service.UserService;

@Component
public class Data {

	@Autowired
	private UserService userService;

	@PostConstruct
	private void add() throws ParseException {

		User user = new User();
		user.setName("Ime");
		user.setSurname("Prezime");
		user.setCity("Grad");
		user.setEmail("email@email.com");
		user.setPassword("password");
		user.setPhone("000");
		user.setUserType(UserType.REGISTROVAN);
		user.setVerified(true);
		userService.save(user);

	}

}
