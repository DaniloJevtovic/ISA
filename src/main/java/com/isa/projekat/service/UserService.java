package com.isa.projekat.service;

import java.util.List;

import com.isa.projekat.model.User;

public interface UserService {

	List<User> findAll();

	User findByEmail(String email);

	User findById(Long id);

	List<User> searchUsers(String name, String surname);

	User login(User user);

	void sendVerificationMail(User user);

	boolean verifyEmail(Long id);

	User save(User user);

	User editUser(User user, Long id);

	//friends
	
	User sendFriendRequest(Long sender, Long reciver);

	User approveFriendRequest(Long sender, Long reciver);

	User declineFriendRequest(Long sender, Long reciver);

	List<User> getFriends(Long id);

	List<User> getFriendRequests(Long id);
	
	User removeFriend(Long userId, Long friendId);
	

}
