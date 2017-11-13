package com.revature.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.revature.domain.*;

@Transactional
public interface UserDao {

	public List<User> getAllUsers();
	
	public User login(String username, String password);

	public User getUserById(int id);

	public User getUserByUsername(String username);

	public int addUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);
}
