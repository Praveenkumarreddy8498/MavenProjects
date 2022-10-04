package com.quiz.model;

/**
 * @author PraveenKumarReddy
 *
 */
public class User {
	private String userName;
	private String name;
	private Long mobileNo;
	private String email;
	private String city;
	private String password;
	private String role;

	public User() {
		super();
	}

	public User(String userName, String name, Long mobileNo, String email, String city, String password, String role) {
		super();
		this.userName = userName;
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		this.city = city;
		this.password = password;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", name=" + name + ", mobileNo=" + mobileNo + ", email=" + email
				+ ", city=" + city + ", password=" + password + ", role=" + role + "]";
	}

}