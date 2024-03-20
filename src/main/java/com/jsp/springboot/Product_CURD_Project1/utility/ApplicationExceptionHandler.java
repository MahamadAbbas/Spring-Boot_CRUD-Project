package com.jsp.springboot.Product_CURD_Project1.utility;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.springboot.Product_CURD_Project1.exception.ProductNotFoundByIdException;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
	
	private ErrorStructure errorStructure;

	public ApplicationExceptionHandler(ErrorStructure errorStructure) {
		this.errorStructure = errorStructure;
	}
	
	//@Override    (why i am not getting to put override (( doubt )) ask sir
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
    		HttpHeaders headers, HttpStatusCode status, WebRequest request)
    {
//		List<ObjectError> errors = ex.getAllErrors();
//
//		List<String> messages = new ArrayList<String>();
//
//		errors.forEach(e -> {
//			String message = e.getDefaultMessage();
//			messages.add(message);
		
//		-----------------------------------------------------------------------
		
//		List<ObjectError> errors = ex.getAllErrors();
		
		Map<String, String> messages = new HashMap<>();
		
		ex.getAllErrors().forEach(e -> {
//			FieldError fieldError = (FieldError) e;
//			String message = e.getDefaultMessage();
//			messages.put(fieldError.getField(), message);
			
			messages.put(((FieldError) e).getField(), e.getDefaultMessage());		//One Line Code
		});

		return ResponseEntity.badRequest().body(
				errorStructure.setStatuscode(HttpStatus.BAD_REQUEST.value()).setErrorMessage("Invalid Inputs").setRootCause(messages)
				);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleProductNotFoundById(ProductNotFoundByIdException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorStructure.setStatuscode(HttpStatus.NOT_FOUND.value()).setErrorMessage("PRODUCT NOT FOUND").setStatuscode(0));
	}
}
