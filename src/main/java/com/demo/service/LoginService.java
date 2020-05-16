package com.demo.service;

import java.util.List;

import com.demo.model.User;

public interface LoginService {

	public boolean isAutheticatedUser(User theUser);

	public List<User> getAllUsers();

	public void saveUser(User user);

	public void deleteUserById(Integer id);

	public User getUserById(Integer id);

	public void addRegisteredUser(User user);

	

}
