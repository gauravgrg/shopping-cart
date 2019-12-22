package com.abc.shopingCart.common;

public enum ProductTypeEnum {

	GROCERY(1, "Grocery"), OTHER(2, "Other");

	private final int type;
	private final String description;

	private ProductTypeEnum(int type, String description) {
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
	 * public static ProductTypeEnum getEnumByType(int type) { for (ProductTypeEnum
	 * productTypeEnum : ProductTypeEnum.values()) { if (productTypeEnum.getType()
	 * == type) { return productTypeEnum; } } throw new
	 * IllegalArgumentException("Invalid ProductTypeEnum type: " + type); }
	 */
}
