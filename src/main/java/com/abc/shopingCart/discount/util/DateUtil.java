package com.abc.shopingCart.discount.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	public static int differenceInYeay(String date) {
		DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date1 = LocalDate.parse(date, dtFormatter);
		LocalDate date2 = LocalDate.now();
		int yearDiff = Period.between(date1, date2).getYears();
		return yearDiff;
	}

}
