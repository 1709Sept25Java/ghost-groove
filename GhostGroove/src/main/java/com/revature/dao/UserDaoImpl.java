package com.revature.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.revature.domain.User;


@Transactional
@Component(value = "userDao")
@Scope(value = "prototype")
public class UserDaoImpl implements UserDao {

	@Autowired
	public SessionFactory sessionFactory;
		@Override
	public List<User> getAllUsers() {
		
			Session s = sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<User> users = s.createQuery("from Users").list();
				for(User user : users){
					System.out.println(user);
				}
			s.close();
			return users;
	}

	@Override
	public User getUserById(int id) {

		Session s = sessionFactory.getCurrentSession();
		User user = (User) s.get(User.class, id);
		s.close();

		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		
		Session s = sessionFactory.getCurrentSession();
		User user = (User) s.get(User.class, username);
		s.close();

		return user;
	}

	@Override
	public User addUser(User user) {
		
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.save(user);
		tx.commit();
		s.close();
		return user;
	}

	@Override
	public void updateUser(User user) {
		
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.merge(user);
		tx.commit();
		s.close();
	}

	@Override
	public void deleteUser(User user) {
		
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.delete(user);
		tx.commit();
		s.close();
		
	}
	
}
