package com.jsp.springboot.Product_CURD_Project1.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.springboot.Product_CURD_Project1.dto.ProductRequest;
import com.jsp.springboot.Product_CURD_Project1.model.Product;
import com.jsp.springboot.Product_CURD_Project1.utility.ResponseStructure;

public interface ProductService {
	
	public ResponseEntity<ResponseStructure<Product>> addProduct(ProductRequest productRequest); 
	
    public ResponseEntity<ResponseStructure<Product>> findProductById(int productId);
	
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, Product updateProduct);
	
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId);
	
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts();


}
