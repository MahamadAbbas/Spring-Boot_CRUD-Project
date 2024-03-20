package com.jsp.springboot.Product_CURD_Project1.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class ApplicationDoc {
	
	Contact contact() {
		return new Contact().name("Mahamad Abbas")
				.url("xyz.in")
				.email("mahamadabbas07@gmail.com");
	}
	
	@Bean
	Info info() {
		return new Info().title("Product Management System")
				.description("RESTful API with basic CRUD operation.")
				.version("v1").contact(contact());                           //.license(null) :- we can also write after getting lincense
	}
    
	@Bean
	OpenAPI openAPI() {
		return new OpenAPI().info(info());
	}
	

}
