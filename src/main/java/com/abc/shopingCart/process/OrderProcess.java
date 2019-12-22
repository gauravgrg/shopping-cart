package com.abc.shopingCart.process;

import com.abc.shopingCart.discount.Discount;
import com.abc.shopingCart.discount.DiscountStrategyFactory;
import com.abc.shopingCart.discount.PurchaseDiscount;
import com.abc.shopingCart.discount.util.OrderUtil;
import com.abc.shopingCart.model.Cart;
import com.abc.shopingCart.model.Customer;

public class OrderProcess {

	private int id;
	private Customer customer;
	private Cart cart;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public double getFinalPrice() {		
		Discount purchaseDiscount = new PurchaseDiscount(
				DiscountStrategyFactory.getPercentageDiscount(customer));
		return OrderUtil.getFullPrice(cart) - purchaseDiscount.getDiscount(cart);
	}
}
