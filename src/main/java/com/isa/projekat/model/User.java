package com.isa.projekat.model;

import static javax.persistence.InheritanceType.JOINED;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = JOINED)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "user_id", nullable = false)
	protected Long userId;
	
	@Column(name = "user_name", nullable = false)
	protected String name;
	
	@Column(name = "user_surname", nullable = false)
	protected String surname;
	
	@Column(name = "user_email", unique = true, nullable = false)
	protected String email;
	
	@Column(name = "user_password", nullable = false)
	protected String password;
	
	@Column(name = "user_adress", nullable = false)
	protected String adress;
	
	@Column(name = "user_phone", nullable = false)
	protected String phone;
	
	@Column(name = "user_city", nullable = false)
	protected String city;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", surname=" + surname + ", email=" + email + ", password="
				+ password + ", adress=" + adress + ", phone=" + phone + ", city=" + city + ", userType=" + userType
				+ "]";
	}

}
