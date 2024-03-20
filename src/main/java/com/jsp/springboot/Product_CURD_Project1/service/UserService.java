package com.jsp.springboot.Product_CURD_Project1.service;

import org.springframework.http.ResponseEntity;

import com.jsp.springboot.Product_CURD_Project1.model.User;
import com.jsp.springboot.Product_CURD_Project1.utility.ResponseStructure;

import jakarta.validation.Valid;

public interface UserService {

     public	ResponseEntity<ResponseStructure<User>> saveUser(@Valid User user);

}
