package com.isa.projekat.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.isa.projekat.model.User;
import com.isa.projekat.model.UserType;
import com.isa.projekat.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Environment enviroment;

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		User user2 = userRepository.findByEmail(user.getEmail());
		if(user2 == null) {
			user.setVerified(false);
			user.setUserType(UserType.REGISTROVAN);
			userRepository.save(user);
			return user;
		}
		
		return null;
		
		//user.setVerified(false);
		//user.setUserType(UserType.REGISTROVAN); // samo privremeno!!! ispravi
		//return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public List<User> searchUsers(String name, String surname) {
		// TODO Auto-generated method stub
		if (!name.equals("nema") && !surname.equals("nema")) {
			return userRepository.findByNameAndSurname(name, surname);
		} else if (name.equals("nema") && !surname.equals("nema")) {
			return userRepository.findBySurname(surname);
		} else if (!name.equals("nema") && surname.equals("nema")) {
			return userRepository.findByName(name);
		} else {
			return userRepository.findAll();
		}
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		User user2 = userRepository.findByEmail(user.getEmail());
		if (user2 != null && user2.isVerified() != false) {
			if (user.getPassword().equals(user2.getPassword())) {
				return user2;
			}
		}
		return null;
	}

	@Override
	@Async
	public void sendVerificationMail(User user) {
		// TODO Auto-generated method stub
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getEmail());
		mailMessage.setFrom(enviroment.getProperty("spring.mail.username"));
		mailMessage.setSubject("Verifikacija naloga");
		mailMessage.setText("Poštovani " + user.getName() + "," 
				+ "\nVerifikaciju Vašeg naloga možete izvršiti na sledećem linku:\n"
				+ "\nhttp://localhost:1111/api/users/verify/" + user.getId() + "");
		mailSender.send(mailMessage);
	}

	@Override
	public boolean verifyEmail(Long id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id);
		user.setVerified(true); 
		userRepository.save(user);
		return true;
	}

	@Override
	public User editUser(User user, Long id) {
		// TODO Auto-generated method stub
		User currentUser = userRepository.findById(id);

		if (user.getEmail() != null) {
			currentUser.setEmail(currentUser.getEmail());
		}

		if (user.getName() != null) {
			currentUser.setName(user.getName());
		}

		if (user.getSurname() != null) {
			currentUser.setSurname(user.getSurname());
		}

		if (user.getCity() != null) {
			currentUser.setCity(user.getCity());
		}

		if (user.getPhone() != null) {
			currentUser.setPhone(user.getPhone());
		}

		if (user.getPassword() != null) {
			currentUser.setPassword(user.getPassword());
		}

		return userRepository.save(currentUser);
	}

	@Override
	public User sendFriendRequest(Long sender, Long reciver) {
		// TODO Auto-generated method stub
		User senderRequest = userRepository.findById(sender);
		User reciverRequest = userRepository.findById(reciver);

		Hibernate.initialize(reciverRequest.getFriendRequests());

		if (reciverRequest != null && sender != reciver) {
			for (User user : reciverRequest.getFriendRequests()) {
				if (user.getId() == sender)
					return null;
			}

			for (User user : getFriends(reciver)) {
				if (user.getId() == sender)
					return null;
			}

			reciverRequest.getFriendRequests().add(senderRequest);
			userRepository.save(reciverRequest);
			return reciverRequest;
		}

		return null;
	}

	@Override
	public User approveFriendRequest(Long sender, Long reciver) {
		// TODO Auto-generated method stub
		User senderRequest = userRepository.findById(sender);
		User reciverRequest = userRepository.findById(reciver);

		Hibernate.initialize(senderRequest.getFriendRequests());
		Hibernate.initialize(senderRequest.getFriends());
		Hibernate.initialize(senderRequest.getFriends2());
		Hibernate.initialize(reciverRequest.getFriendRequests());
		Hibernate.initialize(reciverRequest.getFriends());
		Hibernate.initialize(reciverRequest.getFriends2());

		boolean approved = false;

		for (User user : reciverRequest.getFriendRequests())
			if (user.getId() == sender)
				approved = true;

		if (reciverRequest != null && approved == true) {
			reciverRequest.getFriendRequests().remove(senderRequest);
			senderRequest.getFriendRequests().remove(reciverRequest);
			reciverRequest.getFriends().add(senderRequest);
			userRepository.save(reciverRequest);
			return reciverRequest;
		}

		return null;
	}

	@Override
	public User declineFriendRequest(Long sender, Long reciver) {
		// TODO Auto-generated method stub
		User senderRequest = userRepository.findById(sender);
		User reciverRequest = userRepository.findById(reciver);

		Hibernate.initialize(reciverRequest.getFriendRequests());
		reciverRequest.getFriendRequests().remove(senderRequest);
		userRepository.save(reciverRequest);

		return senderRequest;
	}

	@Override
	public List<User> getFriends(Long id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id);
		Hibernate.initialize(user.getFriends());
		Hibernate.initialize(user.getFriends2());

		if (user != null) {
			List<User> allFriends = new ArrayList<>();
			List<User> friends = user.getFriends();
			List<User> friends2 = user.getFriends2();
			
			allFriends.addAll(friends);
			allFriends.addAll(friends2);
			
			return allFriends;
		}

		return null;
	}

	@Override
	public List<User> getFriendRequests(Long id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id);
		Hibernate.initialize(user.getFriendRequests());
		if(user != null) {
			List<User> friendRequests = user.getFriendRequests();
			return friendRequests;
		}
		
		return null;
	}

	@Override
	public User removeFriend(Long userId, Long friendId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId);
		User friend = userRepository.findById(friendId);
		
		Hibernate.initialize(user.getFriends());
		Hibernate.initialize(friend.getFriends());
		
		List<User> friends = new ArrayList<User>();
		List<User> userFriends = user.getFriends();
		List<User> friendFriends = friend.getFriends();
		friends.addAll(userFriends);
		friends.addAll(friendFriends);
		//sa obje strane treba obrisati prijateljstvo
		
		for(int i=0; i<userFriends.size(); i++) {
			if(userFriends.get(i).getId() == friendId)
				userFriends.remove(i);
		}
		
		for(int i=0; i<friendFriends.size(); i++) {
			if(friendFriends.get(i).getId() == userId)
				friendFriends.remove(i);
		}
		
		userRepository.save(user);
		userRepository.save(friend);
		
		return friend;
	}

}
