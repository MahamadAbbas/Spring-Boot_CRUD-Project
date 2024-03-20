package com.jsp.springboot.Product_CURD_Project1.serviceimpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot.Product_CURD_Project1.model.User;
import com.jsp.springboot.Product_CURD_Project1.repository.UserRepository;
import com.jsp.springboot.Product_CURD_Project1.service.UserService;
import com.jsp.springboot.Product_CURD_Project1.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private ResponseStructure<User> structure;
	
	public UserServiceImpl(UserRepository userRepository, ResponseStructure<User> structure) {
		this.userRepository = userRepository;
		this.structure = structure;
	}

	
	@Override
	public ResponseEntity<ResponseStructure<User>> saveUser(User user)
	{
		User u = userRepository.save(user);
		return ResponseEntity.ok(structure.setStatuscode(HttpStatus.OK.value()).setMessage("User added Successfully").setData(u));
	}

}
