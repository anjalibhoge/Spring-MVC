package com.demo.dao;

import java.util.List;

import com.demo.model.User;

public interface LoginDao {

	public User getUser(User user);

	public List<User> getAllUsers();

	public void saveUser(User user);

	public void deleteUserById(Integer id);

	public User getUserById(Integer id);

	public void addRegisteredUser(User user);

	

}
