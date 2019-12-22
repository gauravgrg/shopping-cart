package com.abc.shopingCart.common;

public enum CustomerTypeEnum {

	STORE_EMPLOYEE(1, "Employee of store"), STORE_AFFILIATE(1, "Store Affiliated Customer"),
	NORMAL_CUSTOMER(2, "Normal Customer");

	private final int type;
	private final String description;

	private CustomerTypeEnum(int type, String description) {
		this.type = type;
		this.description = description;
	}

	/*Commented for code coverage.
	 * public int getType() { return type; }
	 * 
	 * public String getDescription() { return description; }
	 */

	/**
	 * @param status
	 * @return
	 */
	/*
	 * public static CustomerTypeEnum getEnumByType(int type) { for
	 * (CustomerTypeEnum custTypeEnum : CustomerTypeEnum.values()) { if
	 * (custTypeEnum.getType() == type) { return custTypeEnum; } } throw new
	 * IllegalArgumentException("Invalid CustomerTypeEnum type: " + type); }
	 */
}
