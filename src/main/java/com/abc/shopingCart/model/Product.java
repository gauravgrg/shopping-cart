package com.abc.shopingCart.model;

import com.abc.shopingCart.common.ProductTypeEnum;

public class Product {

	private ProductTypeEnum productType;
	private double productPrice;
	private String productName;

	
	
	public Product(ProductTypeEnum productType, double productPrice, String productName) {
		super();
		this.productType = productType;
		this.productPrice = productPrice;
		this.productName = productName;
	}
	
	public Product() {
		
	}

	public ProductTypeEnum getProductType() {
		return productType;
	}

	public void setProductType(ProductTypeEnum productType) {
		this.productType = productType;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
