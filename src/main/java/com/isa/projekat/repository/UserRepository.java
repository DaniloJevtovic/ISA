package com.isa.projekat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.isa.projekat.model.User;

public interface UserRepository extends Repository<User, Long> {
	
	public Page<User> findAll(Pageable pageable);
	
	@Query("select u from User u where u.email = ?1")
	public User findUser(String email);
	
	@Query("select u from User u where u.userId = ?1")
	public User findUserById(Long id);
	
	public User save(User user);
}
