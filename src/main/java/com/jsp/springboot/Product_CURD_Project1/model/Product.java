package com.jsp.springboot.Product_CURD_Project1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private int productPrice;
	private int productDiscount;
	private String productCompany;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductDiscount() {
		return productDiscount;
	}
	public void setProductDiscount(int productDiscount) {
		this.productDiscount = productDiscount;
	}
	public String getProductCompany() {
		return productCompany;
	}
	public void setProductCompany(String productCompany) {
		this.productCompany = productCompany;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDiscount=" + productDiscount + ", productCompany=" + productCompany + "]";
	}
}