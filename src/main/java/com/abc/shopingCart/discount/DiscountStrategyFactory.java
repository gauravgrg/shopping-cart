package com.abc.shopingCart.discount;

import com.abc.shopingCart.common.CustomerTypeEnum;
import com.abc.shopingCart.discount.util.DateUtil;
import com.abc.shopingCart.model.Customer;

public class DiscountStrategyFactory {

	private static Discount employeeDiscount = new EmployeeDiscount();
	private static Discount affilatedCustomerDiscount = new AffiliatedCustomerDiscount();
	private static Discount longAssociationDiscount = new LongAssociationDiscount();
	private static Discount noPercetageDiscount = new NoPercentageDiscount();
	private DiscountStrategyFactory() {
		
	}
	public static Discount getPercentageDiscount(Customer customer) {
		Discount discount = null;
		CustomerTypeEnum customerTypeEnum = customer.getCustomerType();
		if (customerTypeEnum == CustomerTypeEnum.STORE_EMPLOYEE) {
			discount = employeeDiscount;
		} else if (customerTypeEnum == CustomerTypeEnum.STORE_AFFILIATE) {
			discount = affilatedCustomerDiscount;
		} else if (DateUtil.differenceInYeay(customer.getRegistrationDate()) > 1) {
			discount = longAssociationDiscount;
		}
		else {
			discount = noPercetageDiscount;
		}
		return discount;
	}

}
