package com.isa.projekat.model;

import static javax.persistence.InheritanceType.JOINED;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = JOINED)
public class User implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "user_id", nullable = false)
	protected Long userId;
	
	@Column(name = "user_email", unique = true, nullable = false)
	protected String email;
	
	@Column(name = "user_password", nullable = false)
	protected String password;
	
	@Column(name = "user_type", nullable = false)
	protected String userType;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
