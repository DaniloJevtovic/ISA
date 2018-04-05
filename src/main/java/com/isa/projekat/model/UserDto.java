package com.isa.projekat.model;

public class UserDto {
	
	private Long id;
	private String email;
	private String name;
	private String surname;
	private String password;
	private String city;
	private String phone;
	private UserType userType;
	private boolean verified;

	public UserDto(User user) {
		this.id = user.getId();
		this.email=user.getEmail();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.password = user.getPassword();
		this.city = user.getCity();
		this.phone = user.getPhone();
		this.userType = user.getUserType();
		this.verified = user.isVerified();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

}
