package com.jsp.springboot.Product_CURD_Project1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.Product_CURD_Project1.model.User;
import com.jsp.springboot.Product_CURD_Project1.service.UserService;
import com.jsp.springboot.Product_CURD_Project1.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping(value = "/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@Valid @RequestBody User user){
		return userService.saveUser(user);
	}

}
