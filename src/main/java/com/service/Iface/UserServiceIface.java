package com.service.Iface;

import java.util.List;

import com.entity.User;

public interface UserServiceIface {
	
	public User validateUser(String username, String password) throws Exception;
	public User addUser(User user);
	public void removeUser(int id);
	public User updateUser(User user, int userId);
	public List<User> viewUsers();

}
