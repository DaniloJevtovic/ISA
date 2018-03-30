package com.isa.projekat.service;

import org.springframework.data.domain.Page;

import com.isa.projekat.model.User;

public interface UserService {
	
	Page<User> findUsers();
	User getUser(String email);
	User getUserById(Long id);
}
