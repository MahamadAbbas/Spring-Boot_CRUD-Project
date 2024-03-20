package com.jsp.springboot.Product_CURD_Project1.utility;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructure<E> {
	
	private int statuscode;
	private String message;
	private E data;
	
	public int getStatuscode() {
		return statuscode;
	}
	public ResponseStructure<E> setStatuscode(int statuscode) {
		this.statuscode = statuscode;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public ResponseStructure<E> setMessage(String message) {
		this.message = message;
		return this;
	}
	public E getData() {
		return data;
	}
	public ResponseStructure<E> setData(E data) {
		this.data = data;
		return this;
	}	
}
