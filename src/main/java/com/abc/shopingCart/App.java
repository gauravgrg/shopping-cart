package com.abc.shopingCart;

import com.abc.shopingCart.common.CustomerTypeEnum;
import com.abc.shopingCart.common.ProductTypeEnum;
import com.abc.shopingCart.model.Cart;
import com.abc.shopingCart.model.Customer;
import com.abc.shopingCart.model.Product;
import com.abc.shopingCart.process.OrderProcess;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Customer customer = new Customer();

		customer.setCustomerType(CustomerTypeEnum.STORE_EMPLOYEE);
		customer.setRegistrationDate("2016-12-21");

		Cart cart = new Cart();
		cart.addProduct(new Product(ProductTypeEnum.GROCERY, 100d, "Flour"));
		cart.addProduct(new Product(ProductTypeEnum.OTHER, 100d, "Mop"));
		cart.addProduct(new Product(ProductTypeEnum.OTHER, 100d, "Soap"));

		OrderProcess ordProcess = new OrderProcess();

		ordProcess.setCart(cart);
		ordProcess.setCustomer(customer);

		double finalPrice = ordProcess.getFinalPrice();

		System.out.println(finalPrice);

	}
}
