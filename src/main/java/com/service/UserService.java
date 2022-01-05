package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;
import com.service.Iface.UserServiceIface;

@Service
public class UserService implements UserServiceIface{
	
	private UserRepository userRepo;
	
	@Autowired
	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public User validateUser(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public void removeUser(int id) {
		userRepo.findById(id).orElseThrow();
		
		userRepo.deleteById(id);
	}

	@Override
	public User updateUser(User user, int userId) {
		User existingUser = userRepo.findById(userId).orElseThrow();
		
		existingUser.setFirsrtName(user.getFirsrtName());
		existingUser.setLastName(user.getLastName());
		existingUser.setUsername(user.getUsername());
		existingUser.setPassword(user.getPassword());
		existingUser.setEmail(user.getEmail());
		existingUser.setMobileNumber(user.getPassword());
		
		userRepo.save(existingUser);
		return existingUser;
	}

	@Override
	public List<User> viewUsers() {
		return userRepo.findAll();
	}

}
