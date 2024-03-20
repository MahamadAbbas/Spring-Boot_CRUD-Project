package com.jsp.springboot.Product_CURD_Project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.springboot.Product_CURD_Project1.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
