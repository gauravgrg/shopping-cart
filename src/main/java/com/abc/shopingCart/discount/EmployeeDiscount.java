package com.abc.shopingCart.discount;

import com.abc.shopingCart.common.ProductTypeEnum;
import com.abc.shopingCart.discount.util.OrderUtil;
import com.abc.shopingCart.model.Cart;

public class EmployeeDiscount implements Discount {

	
	public double getDiscount(Cart cart) {
		int discuoutPercentage = 30;
		double discount=0;
		double priceOfNonGroceryItem = OrderUtil.getPriceByCategory(cart, ProductTypeEnum.OTHER);
		discount = (priceOfNonGroceryItem * discuoutPercentage)/100;
		return discount;
	}

	

}
