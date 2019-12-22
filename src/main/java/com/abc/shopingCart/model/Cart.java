package com.abc.shopingCart.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private int id;
	private List<Product> productList;

	
	
	public Cart() {
		productList = new ArrayList<Product>();
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public List<Product> getProductList() {
		return productList;
	}
	
	public void addProduct(Product product) {
		productList.add(product);
	}

}
