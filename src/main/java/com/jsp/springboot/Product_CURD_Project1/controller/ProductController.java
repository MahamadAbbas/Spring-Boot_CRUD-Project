package com.jsp.springboot.Product_CURD_Project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.Product_CURD_Project1.dto.ProductRequest;
import com.jsp.springboot.Product_CURD_Project1.model.Product;
import com.jsp.springboot.Product_CURD_Project1.service.ProductService;
import com.jsp.springboot.Product_CURD_Project1.utility.ErrorStructure;
import com.jsp.springboot.Product_CURD_Project1.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class ProductController {
	
	//@Autowired                               //Field dependency Injection
	//private ProductService productService;
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
    
	@Operation(description = "the endpoint is used to the add new product to the database", responses = {
		@ApiResponse(responseCode = "200", description = "Product saved Successfully"),
		@ApiResponse(responseCode = "400", description = "Invalid Inputs")
	})
	@PostMapping(value = "/products")
	public ResponseEntity<ResponseStructure<Product>> addProduct(@RequestBody ProductRequest productRequest){
		return productService.addProduct(productRequest);
	}
	

	@Operation(description = "The end point is used to fetch the product based on the ID", responses = {
			@ApiResponse(responseCode = "200", description = "Product found"),
			@ApiResponse(responseCode = "404", description = "Product not found by given ID", content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
	})
	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> findByProductId(@PathVariable int productId) {
		return productService.findProductById(productId);
	}
	
	@PutMapping(value = "/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(@PathVariable int productId, @RequestBody Product product) {
		return productService.updateByProductId(productId, product);
	}
	
	@DeleteMapping(value = "/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(@PathVariable int productId) {
		return productService.deleteByProductId(productId);
	}
	
	@GetMapping(value = "/products")
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts(){
	return productService.findAllProducts();

	}
}
