package com.jsp.springboot.Product_CURD_Project1.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot.Product_CURD_Project1.dto.ProductRequest;
import com.jsp.springboot.Product_CURD_Project1.exception.ProductNotFoundByIdException;
import com.jsp.springboot.Product_CURD_Project1.model.Product;
import com.jsp.springboot.Product_CURD_Project1.repository.ProductRepository;
import com.jsp.springboot.Product_CURD_Project1.service.ProductService;
import com.jsp.springboot.Product_CURD_Project1.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@Service
public class ProductServiceImpl implements ProductService {
	
	//@Autowired                                             //Field dependency injection
	//private ProductRepository productRepository;
	
	private ProductRepository productRepository;
	private ResponseStructure<Product> structure;
	private ResponseStructure<List<Product>> structureList;
	
	

	public ProductServiceImpl(ProductRepository productRepository, ResponseStructure<Product> structure,
			ResponseStructure<List<Product>> structureList) {
		this.productRepository = productRepository;
		this.structure = structure;
		this.structureList = structureList;
	}
	
	//Coverting DTO(ProductRequest) to Product
	private Product mapToProduct(ProductRequest productRequest, Product product)
	{
		product.setProductName(productRequest.getProductName());
		product.setProductPrice(productRequest.getProductPrice());
		return product;
	}
	

	@Override
	public ResponseEntity<ResponseStructure<Product>> addProduct(ProductRequest productRequest) 
	{
		//mapping DTO to Entity
		Product product = productRepository.save(mapToProduct(productRequest, new Product()));
		
		return ResponseEntity.ok(structure.setStatuscode(HttpStatus.OK.value()).setMessage("Product ADDED").setData(product));
		
//		Product product2 = productRepository.save(product);
//		
//		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
//		responseStructure.setStatuscode(HttpStatus.CREATED.value());
//		responseStructure.setMessage("Product object created sucessfully");
//		responseStructure.setData(product2);
//		
//		return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> findProductById(int productId) {
		
//		Optional<Product> optional = productRepository.findById(productId);
//
//		if(optional.isPresent()) {
//			Product product = optional.get();
//
//			ResponseStructure<Product> responseStructure = new ResponseStructure<>();
//			responseStructure.setStatuscode(HttpStatus.FOUND.value());
//			responseStructure.setMessage("Actor Found Successfully");
//			responseStructure.setData(product);
//
//			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.FOUND);
//		}
//        else {
//			throw new ProductNotFoundByIdException("Product Not Found");
//		}
		
		return productRepository.findById(productId).map(product->ResponseEntity.ok(
				structure.setStatuscode(HttpStatus.OK.value())
				.setMessage("Product FOUND")
				.setData(product))).orElseThrow(() -> new ProductNotFoundByIdException("NOT FOUND"));
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, Product product) {

		//		Optional<Product> optional = productRepository.findById(productId);
//
//		if(optional.isPresent()) {
//			Product existingProduct = optional.get();
//			updateProduct.setProductId(productId);
//			Product product = productRepository.save(updateProduct);
//
//			ResponseStructure<Product> responseStructure = new ResponseStructure<>();
//			responseStructure.setStatuscode(HttpStatus.OK.value());
//			responseStructure.setMessage("Sucessfully Updated");
//			responseStructure.setData(product);
//
//			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
//		}
//		else {
//			return null;
//		}
		
		
		return productRepository.findById(productId).map(existingProduct -> {
			product.setProductId(existingProduct.getProductId());
			existingProduct = productRepository.save(product);
			return ResponseEntity.ok(structure.setStatuscode(HttpStatus.OK.value())
					.setMessage("Product Updated")
					.setData(existingProduct));
		}).orElseThrow(() -> new ProductNotFoundByIdException("Product not found by ID"));	
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId) {
		Optional<Product> optional = productRepository.findById(productId);

		if(optional.isPresent()) {
		    Product product = optional.get();
			productRepository.delete(product);                    //productRepository.deleteById(productId);
			
			ResponseStructure<Product> responseStructure = new ResponseStructure<>();
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Actor Sucessfulluy Deleted");
			responseStructure.setData(product);
			
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		}
		else {
			return null;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts() {
		List<Product> productList = productRepository.findAll();

		if(productList.isEmpty()) {
			throw new RuntimeException("Products Not Found");
		}
		else {
			
//			ResponseStructure<List<Product>> responseStructure = new ResponseStructure<>();
//			responseStructure.setStatuscode(HttpStatus.FOUND.value());
//			responseStructure.setMessage("Found All Actors");
//			responseStructure.setData(products);
//			
//			return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure, HttpStatus.FOUND);
			
			return ResponseEntity.ok(
					structureList.setStatuscode(HttpStatus.OK.value())
					.setMessage("Products Found")
					.setData(productList)
					);
		}
	}

}
