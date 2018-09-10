package com.isa.projekat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "user_email", nullable = false)
	private String email;

	@Column(name = "user_password", nullable = false)
	private String password;

	@Column(name = "user_name", nullable = true)
	private String name;

	@Column(name = "user_surname", nullable = true)
	private String surname;

	@Column(name = "user_city", nullable = true)
	private String city;

	@Column(name = "user_phone", nullable = true)
	private String phone;

	@Column(name = "user_type", nullable = false)
	private UserType userType;

	@Column(name = "user_verified", nullable = false)
	private boolean verified;

	@OneToMany
	private List<Reservation> reservations;
	
	@ManyToMany
	@JoinTable(name="friends", joinColumns=@JoinColumn(name="personId"), inverseJoinColumns=@JoinColumn(name="friendId"))
	private List<User> friends;
	
	@ManyToMany
	@JoinTable(name="friends", joinColumns=@JoinColumn(name="friendId"), inverseJoinColumns=@JoinColumn(name="personId"))
	private List<User> friends2; 
	
	@ManyToMany
	@JoinTable(name="requests", joinColumns=@JoinColumn(name="receiver"))
	private List<User> friendRequests;

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType usertype) {
		this.userType = usertype;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<User> getFriendRequests() {
		return friendRequests;
	}

	public void setFriendRequests(List<User> friendRequests) {
		this.friendRequests = friendRequests;
	}

	public List<User> getFriends2() {
		return friends2;
	}

	public void setFriends2(List<User> friends2) {
		this.friends2 = friends2;
	}

}
