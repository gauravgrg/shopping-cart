package com.abc.shopingCart.discount.util;

import com.abc.shopingCart.common.ProductTypeEnum;
import com.abc.shopingCart.model.Cart;

public class OrderUtil {

	public static double getFullPrice(Cart cart) {
		double result = cart.getProductList().stream()
				.map(product -> product.getProductPrice())
				.reduce(0d,Double::sum);
		return result;
	}

	public static double getPriceByCategory(Cart cart, ProductTypeEnum productTypeEnum) {
		double result = cart.getProductList()
				.stream()
				.filter(product -> product.getProductType() == productTypeEnum)
				.map(product -> product.getProductPrice())
				.reduce(0d, Double::sum);
		return result;
	}
}
