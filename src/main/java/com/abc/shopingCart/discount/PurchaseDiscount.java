package com.abc.shopingCart.discount;

import com.abc.shopingCart.discount.util.OrderUtil;
import com.abc.shopingCart.model.Cart;

public class PurchaseDiscount implements Discount {
	Discount percentageDiscount;

	public PurchaseDiscount(Discount discount) {
		this.percentageDiscount = discount;
	}

	public double getDiscount(Cart cart) {
		int discuoutFactor = 5;
		double percentDiscount = percentageDiscount.getDiscount(cart);

		double percentDicountPrice = OrderUtil.getFullPrice(cart) - percentDiscount;
		double discountOnBill = ((int)percentDicountPrice / 100) * discuoutFactor;

		return percentDiscount + discountOnBill;

	}
}
