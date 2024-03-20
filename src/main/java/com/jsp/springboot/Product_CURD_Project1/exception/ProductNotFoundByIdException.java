package com.jsp.springboot.Product_CURD_Project1.exception;

public class ProductNotFoundByIdException extends RuntimeException{
	
	private String message;

	public ProductNotFoundByIdException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
