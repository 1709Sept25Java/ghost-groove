package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface UserDao {

	public List<User> getAllUsers();

	public User getUserById(int uId);

	public User getUserByUsername(String username);

	public int addUser(User user);

	public void updateUser(User updateU);

	public void deleteUser(User deleteU);
}
