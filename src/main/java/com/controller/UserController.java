
package com.controller;


import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Repository.UserRepository;
import com.beans.User;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private final UserRepository userRepo;
	
	@Autowired
	public UserController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@RequestMapping(value = "/getAllUser")
	public Collection<User> getAllUser(){
		
		return userRepo.findAll();
	}
	
}
