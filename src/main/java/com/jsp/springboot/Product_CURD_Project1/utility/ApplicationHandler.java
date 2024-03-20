package com.jsp.springboot.Product_CURD_Project1.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot.Product_CURD_Project1.exception.ProductNotFoundByIdException;

//@RestControllerAdvice
//public class ApplicationHandler {
//	
//	@ExceptionHandler
//	public ResponseEntity<ErrorStructure<String>> productNotFoundByIdException(ProductNotFoundByIdException er){
//		
//		ErrorStructure<String> errorStructure = new ErrorStructure<>();
//		errorStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
//		errorStructure.setErrorMessage(er.getMessage());
//		errorStructure.setErrorData("Product object with the given Id Does't Exist");
//		
//		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
//		
//	}
//
//}
