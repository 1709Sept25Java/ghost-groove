package com.revature.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.domain.User;


@Transactional

@Repository(value="userDao")
@Scope(value="session")

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
	public User getUserById(int uId) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from User where id=:idVar");
		q.setInteger("idVar", uId);
		User user = (User)q.uniqueResult();
		tx.commit();

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

		
		
	public int addUser(User user) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		int result = 0;
		s.saveOrUpdate(user);
		tx.commit();
		return user.getId();
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
