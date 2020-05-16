package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.LoginDao;
import com.demo.model.User;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	public boolean isAutheticatedUser(User theUser) {
		User user = loginDao.getUser(theUser);
		if(null != user) {
			if(theUser.getPassword().equals(user.getPassword())) {
			return true;
			} 
		}
		return false;
	}
	
	
	public List<User> getAllUsers() {
		return loginDao.getAllUsers();
	}

	public void saveUser(User user) {
		loginDao.saveUser(user);
	}

	public void deleteUserById(Integer id) {
		loginDao.deleteUserById(id);
	}

	public User getUserById(Integer id) {
		return loginDao.getUserById(id);
	}


	public void addRegisteredUser(User user) {
		loginDao.addRegisteredUser(user);
	}

}
