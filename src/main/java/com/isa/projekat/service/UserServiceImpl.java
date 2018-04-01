package com.isa.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.isa.projekat.model.User;
import com.isa.projekat.repository.UserRepository;

import org.springframework.util.Assert;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Page<User> findUsers() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll(new PageRequest(0, 20));
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		Assert.notNull(email, "Email ne moze biti null");
		return this.userRepository.findUser(email);
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		Assert.notNull(id, "Id ne moze biti null");
		return this.userRepository.findUserById(id);
	}
	

}
