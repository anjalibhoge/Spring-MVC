package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true,nullable = false)
	private Integer id;
	
	@Column(name = "username",nullable = false,length = 45)
	private String username;
	
	@Column(name = "password",nullable = false,length = 45)
	private String password;
	
	@Column(name = "email",nullable = false,length = 45)
	private String email;
	
	@Column(name = "gender",nullable = false,length = 45)
	private String gender;
	
	@Column(name = "state",nullable = false,length = 45)
	private String state;
	
	@Column(name = "course",nullable = false,length = 45)
	private String course;
	
	@Column(name = "mobile",nullable = false)
	private Integer mobile;

	public User(Integer id, String username, String password, String email, String gender, String state, String course,
			Integer mobile) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.state = state;
		this.course = course;
		this.mobile = mobile;
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", gender="
				+ gender + ", state=" + state + ", course=" + course + ", mobile=" + mobile + "]";
	}

}
