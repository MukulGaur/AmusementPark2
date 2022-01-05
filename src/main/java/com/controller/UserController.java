package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

@RestController
@RequestMapping(path="/api")
public class UserController {
	
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
//	Insert new user
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
	}
	
//	View all users
	@GetMapping("/viewUsers")
	public List<User> viewUsers(){
		return userService.viewUsers();
	}
	
//	Delete user by Id
	@DeleteMapping("/deleteUserById/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable int userId){
		userService.removeUser(userId);
		return new ResponseEntity<String>("User record deleted successfully !", HttpStatus.OK);
	}
	
//	Update user by Id
	@PutMapping("/updateUserById/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int userId){
		return new ResponseEntity<User>(userService.updateUser(user, userId), HttpStatus.OK);
	}

}
