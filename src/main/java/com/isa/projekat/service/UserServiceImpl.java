package com.isa.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.projekat.model.User;
import com.isa.projekat.model.UserType;
import com.isa.projekat.repository.UserRepository;

@Service
@Transactional
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
		user.setUserType(UserType.REGISTROVAN);	//samo privremeno!!! ispravi
		return userRepository.save(user);
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
		if(!name.equals("nema") && !surname.equals("nema")) {
			return userRepository.findByNameAndSurname(name, surname);
		}else if(name.equals("nema") && !surname.equals("nema")) {
			return userRepository.findBySurname(surname);
		}else if(!name.equals("nema") && surname.equals("nema")) {
			return userRepository.findByName(name);
		}else {
			return userRepository.findAll();
		}
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		User user2 = userRepository.findByEmail(user.getEmail());
		if(user2 != null) {
			if(user.getPassword().equals(user2.getPassword())) {
				return user2;
			}
		}
		return null;
	}

	@Override
	public void sendVerificationMail(User user) {
		// TODO Auto-generated method stub
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getEmail());
		mailMessage.setFrom(enviroment.getProperty("spring.mail.username"));
		mailMessage.setSubject("Verifikacija naloga");
		mailMessage.setText("Pozdrav " + user.getName() + "," + "\nLink za verifikaciju je sledeci:\n" + "\nhttp://localhost:1111/api/users/verify/" + user.getId() + "");
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
	
}
