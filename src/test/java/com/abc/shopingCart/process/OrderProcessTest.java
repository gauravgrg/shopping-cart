package com.abc.shopingCart.process;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.abc.shopingCart.common.CustomerTypeEnum;
import com.abc.shopingCart.common.ProductTypeEnum;
import com.abc.shopingCart.model.Cart;
import com.abc.shopingCart.model.Customer;
import com.abc.shopingCart.model.Product;

public class OrderProcessTest {
	OrderProcess orderProcess;
	@Before
	public void setUpBeforeTest() throws Exception {
		orderProcess = new OrderProcess();
		orderProcess.setId(1);
		orderProcess.setCart(new Cart());
		orderProcess.setCustomer(new Customer());
	}

	@After
	public void tearDownAfterTest() throws Exception {
		orderProcess = null;
	}

	@Test
	public void testGetFinalPriceEmpDiscount() {
		Customer customer = orderProcess.getCustomer();
		Cart cart = orderProcess.getCart();
		customer.setCustomerType(CustomerTypeEnum.STORE_EMPLOYEE);
		customer.setId(1);
		customer.setName("Customer1");
		//customer.setRegistrationDate("2016-12-21");
		cart.setId(1);
		cart.addProduct(new Product(ProductTypeEnum.GROCERY, 100d, "Flour"));
		cart.addProduct(new Product(ProductTypeEnum.OTHER, 100d, "Mop"));
		cart.addProduct(new Product(ProductTypeEnum.OTHER, 100d, "Soap"));
		
		Assert.assertEquals(230d, orderProcess.getFinalPrice());
	}
	
	@Test
	public void testGetFinalPriceAffilatedCustomerDiscount() {
		Customer customer = orderProcess.getCustomer();
		Cart cart = orderProcess.getCart();
		customer.setCustomerType(CustomerTypeEnum.STORE_AFFILIATE);
		//customer.setRegistrationDate("2016-12-21");
		
		cart.addProduct(new Product(ProductTypeEnum.GROCERY, 100d, "Flour"));
		cart.addProduct(new Product(ProductTypeEnum.OTHER, 100d, "Mop"));
		cart.addProduct(new Product(ProductTypeEnum.OTHER, 100d, "Soap"));
		
		Assert.assertEquals(270d, orderProcess.getFinalPrice());
	}
	
	@Test
	public void testGetFinalPriceLongAssociatedCustomerDiscount() {
		Customer customer = orderProcess.getCustomer();
		Cart cart = orderProcess.getCart();
		customer.setCustomerType(CustomerTypeEnum.NORMAL_CUSTOMER);
		customer.setRegistrationDate("2016-12-21");
		
		cart.addProduct(new Product(ProductTypeEnum.GROCERY, 100d, "Flour"));
		cart.addProduct(new Product(ProductTypeEnum.OTHER, 100d, "Mop"));
		Product product = new Product();
		product.setProductName("Soap");
		product.setProductType(ProductTypeEnum.OTHER);
		product.setProductPrice(100d);
		cart.addProduct(product);
		Assert.assertEquals(280d, orderProcess.getFinalPrice());
	}
	
	@Test
	public void testGetFinalPriceNormalPurchaseDiscount() {
		Customer customer = orderProcess.getCustomer();
		Cart cart = orderProcess.getCart();
		customer.setCustomerType(CustomerTypeEnum.NORMAL_CUSTOMER);
		customer.setRegistrationDate("2018-12-21");
		
		cart.addProduct(new Product(ProductTypeEnum.GROCERY, 100d, "Flour"));
		
		Product product = new Product();
		product.setProductName("Mop");
		product.setProductType(ProductTypeEnum.OTHER);
		product.setProductPrice(100d);
		cart.addProduct(product);
		
		Product product1 = new Product(); 
		
		product1.setProductName(product.getProductName());
		product1.setProductType(product.getProductType());
		product1.setProductPrice(product.getProductPrice());
		cart.addProduct(product);
		
		
		Assert.assertEquals(285d, orderProcess.getFinalPrice());
	}
	
	@Test
	public void testGetFinalPriceNoDiscount() {
		Customer customer = orderProcess.getCustomer();
		Cart cart = orderProcess.getCart();
		customer.setCustomerType(CustomerTypeEnum.NORMAL_CUSTOMER);
		customer.setRegistrationDate("2018-12-21");
		
		cart.addProduct(new Product(ProductTypeEnum.GROCERY, 10d, "Flour"));
		cart.addProduct(new Product(ProductTypeEnum.OTHER, 10d, "Mop"));
		cart.addProduct(new Product(ProductTypeEnum.OTHER, 10d, "Soap"));
		
		Assert.assertEquals(30d, orderProcess.getFinalPrice());
	}

}
