package com.gm.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
	public static final String f1 = "yyyy-MM-dd";
	public static final String f2 = "yyyy-MM-dd HH:mm:ss";
	public static final String f3 = "yyyy-MM-dd HH:mm";
	public static final String f4 = "HH:mm:ss";
	public static final String f5 = "yyyy-MM-dd HH";
	public static final String f6 = "yyyyMMddHHmmss";
	public static final String f7 = "yyyy年MM月dd日";
	public static final String f8 = "MM月dd日 HH:mm";
	public static final String f9 = "yyyyMMdd";
	public static final String f10 = "MM-dd";
	public static final String f11 = "HH:mm";

	public static LocalDateTime convert(String datetime, String p) {
		if (!StringUtil.strNullOrEmpty(datetime)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(p);
			LocalDateTime newDatetime = LocalDateTime.parse(datetime, formatter);
			return newDatetime;
		}
		return null;
	}

	/**
	 * 时间转成字符串
	 * 
	 * @param d
	 * @param p
	 * @return
	 */
	public static String format(LocalDateTime localDateTime, String p) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(p);
		return formatter.format(localDateTime);
	}

	public static String format(LocalDate localDate, String p) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(p);
		return formatter.format(localDate);
	}

}