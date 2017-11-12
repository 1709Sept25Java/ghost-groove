package com.revature.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.domain.User;

@Repository(value="userDao")
@Scope(value="session")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<User> getAllUsers() {
		
		return null;
	}

	@Override
	public User getUserById(int uId) {

		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		
		return null;
	}

	@Override
	public int addUser(User user) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		int result = 0;
		s.saveOrUpdate(user);
		tx.commit();
		return user.getId();
	}

	@Override
	public void updateUser(User updateU) {
		
	}

	@Override
	public void deleteUser(User deleteU) {
		
		
	}

	@Override
	public User login(String username, String password) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query q = s.getNamedQuery("login");
		q.setString("unameVar", username);
		q.setString("pwVar", password);
		User u = (User) q.uniqueResult();
		tx.commit();
		return u;
	}
	
}
