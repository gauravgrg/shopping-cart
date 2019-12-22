package com.abc.shopingCart.discount;

import com.abc.shopingCart.model.Cart;

public class NoPercentageDiscount implements Discount {

	public double getDiscount(Cart cart) {
		
		return 0;
	}

}
