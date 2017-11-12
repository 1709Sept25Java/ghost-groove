package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface UserDao {

	public List<User> getAllUsers();

	public User getUserById(int id);

	public User getUserByUsername(String username);

	public User addUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);
}
