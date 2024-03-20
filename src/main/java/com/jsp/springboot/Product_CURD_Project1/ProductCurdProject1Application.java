package com.jsp.springboot.Product_CURD_Project1;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jsp.springboot.Product_CURD_Project1.model.Product;

@SpringBootApplication
public class ProductCurdProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductCurdProject1Application.class, args);
		
//      Product product = new Product();
//      Optional.of(product).map(ms -> {System.out.println("Inside map"); return ms;}).orElseThrow(() -> new RuntimeException());
	}
	
}
