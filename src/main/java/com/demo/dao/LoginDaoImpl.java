package com.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.User;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {

	@Autowired
	SessionFactory sessionFactory;

	public User getUser(User user1) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "FROM User U WHERE U.email = :user_id AND U.password = :user_password";
		Query query = session.createQuery(hql);
		
		query.setParameter("user_id",user1.getEmail());
		query.setParameter("user_password",user1.getPassword());
	
		List<User> users = query.list();
		tx.commit();
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}
	
	
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		List<User> users = query.list();
		tx.commit();
		return users;
	}

	public void saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
	}

	public void deleteUserById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		User user = session.get(User.class,id);
		if(null != user ) {
			session.delete(user);
		}
		tx.commit();
	}

	public User getUserById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		User user = session.get(User.class,id);
		tx.commit();
		return user;
	}


	public void addRegisteredUser(User user) {
		
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(user);
			tx.commit();
		}
		
	}


