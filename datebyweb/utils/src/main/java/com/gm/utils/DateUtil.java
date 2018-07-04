package com.gm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 时间工具类
 * 
 * public static final String f2 = "yyyy-MM-dd HH:mm:ss"; <br/>
 * public static final String f3 = "yyyy-MM-dd HH:mm";<br/>
 * public static final String f4 = "HH:mm:ss";<br/>
 * public static final String f5 = "yyyy-MM-dd HH"; <br/>
 * public static final String f6 = "yyyyMMddHHmmss"; <br/>
 * public static final String f7 = "yyyy年MM月dd日"; <br/>
 * public static final String f8 = "MM月dd日 HH:mm";<br/>
 * 
 * @author guet
 *
 */
public class DateUtil {
	public static final String f1 = "yyyy-MM-dd";
	public static final String f2 = "yyyy-MM-dd HH:mm:ss";
	public static final String f3 = "yyyy-MM-dd HH:mm";
	public static final String f4 = "HH:mm:ss";
	public static final String f5 = "yyyy-MM-dd HH";
	public static final String f6 = "yyyyMMddHHmmss";
	public static final String f7 = "yyyy年MM月dd日";
	public static final String f8 = "MM月dd日 HH:mm";
	public static final String f9 = "yyyyMMdd";
	public static final String f10 = "yyyyMMddHHmmssSSS";

	/**
	 * 字符串转化成日期 ("yyyy-MM-dd HH:mm:ss")格式
	 * 
	 * @param String
	 * @return Date
	 */
	public static Date convert(String date) {
		if (!StringUtil.strNullOrEmpty(date)) {
			SimpleDateFormat sdf = new SimpleDateFormat(f2);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	/**
	 * 字符串转化成日期
	 * 
	 * @param date
	 * @param p
	 * @return
	 */
	public static Date convert(String date, String p) {
		Date retValue = null;
		if (!StringUtil.strNullOrEmpty(date)) {
			SimpleDateFormat sdf = new SimpleDateFormat(p);
			try {
				retValue = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return retValue;
	}

	/**
	 * 时间转成字符串
	 * 
	 * @param d
	 * @param p
	 * @return
	 */
	public static String format(Date d, String p) {
		return DateFormatUtils.format(d, p);
	}

	public static String format(LocalDateTime d, String p) {
		return d.format(DateTimeFormatter.ofPattern(p));
	}

	/**
	 * 获取某天开始时间
	 *
	 * @return Date
	 */
	public static Date getTodayStartTime(Date date) {
		Calendar currentDate = new GregorianCalendar();
		currentDate.setTime(date);
		currentDate.set(Calendar.HOUR_OF_DAY, 0);
		currentDate.set(Calendar.MINUTE, 0);
		currentDate.set(Calendar.SECOND, 0);

		return currentDate.getTime();
	}

	/**
	 * 获取某天的最后时间
	 *
	 * @return Date
	 */
	public static Date getTodayEndTime(Date date) {
		Calendar currentDate = new GregorianCalendar();
		currentDate.setTime(date);
		currentDate.set(Calendar.HOUR_OF_DAY, 23);
		currentDate.set(Calendar.MINUTE, 59);
		currentDate.set(Calendar.SECOND, 59);
		return currentDate.getTime();
	}

	/**
	 * 本月的开始时间
	 */
	public static Date getFirstDayOfMonth() {
		LocalDate date = LocalDate.now();
		LocalDateTime localDateTime = date.with(TemporalAdjusters.firstDayOfMonth()).atTime(00, 00);
		String s = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return convert(s);
	}

	/**
	 * 本月的最后时间
	 */
	public static Date getLastDayOfMonth() {
		LocalDate date = LocalDate.now();
		LocalDateTime localDateTime = date.with(TemporalAdjusters.lastDayOfMonth()).atTime(23, 59, 59);

		String s = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return convert(s);
	}

	/**
	 * 获取随机日期
	 *
	 */

	public static Date randomDate(Date start, Date end) {
		try {
			if (start.getTime() >= end.getTime()) {
				return null;
			}
			long date = random(start.getTime(), end.getTime());

			return new Date(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static long random(long begin, long end) {
		long rtn = begin + (long) (Math.random() * (end - begin));
		// 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
		if (rtn == begin || rtn == end) {
			return random(begin, end);
		}
		return rtn;
	}

	/**
	 * 获取某段日期内的日期集合
	 *
	 * @param dBegin
	 * @param dEnd
	 * @return
	 */
	public static List<Date> getDates(Date dBegin, Date dEnd) {
		List<Date> lDate = new ArrayList();
		lDate.add(dBegin);
		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(dEnd);
		// 测试此日期是否在指定日期之后
		while (dEnd.after(calBegin.getTime())) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			lDate.add(calBegin.getTime());
		}
		return lDate;
	}

	/**
	 * 获取当月日期集合
	 *
	 * @return
	 */
	public List<Date> getCurMonthDays() {
		return getDates(getFirstDayOfMonth(), getLastDayOfMonth());
	}

	/**
	 * 变量：日期格式化类型 - 格式:yyyy/MM/dd
	 */
	public static final int DEFAULT = 0;
	public static final int YM = 1;

	/**
	 * 变量：日期格式化类型 - 格式:yyyy-MM-dd
	 * 
	 */
	public static final int YMR_SLASH = 11;

	/**
	 * 变量：日期格式化类型 - 格式:yyyyMMdd
	 * 
	 */
	public static final int NO_SLASH = 2;

	/**
	 * 变量：日期格式化类型 - 格式:yyyyMM
	 * 
	 */
	public static final int YM_NO_SLASH = 3;

	/**
	 * 变量：日期格式化类型 - 格式:yyyy/MM/dd HH:mm:ss
	 * 
	 */
	public static final int DATE_TIME = 4;

	/**
	 * 变量：日期格式化类型 - 格式:yyyyMMddHHmmss
	 * 
	 */
	public static final int DATE_TIME_NO_SLASH = 5;

	/**
	 * 变量：日期格式化类型 - 格式:yyyy/MM/dd HH:mm
	 * 
	 */
	public static final int DATE_HM = 6;

	/**
	 * 变量：日期格式化类型 - 格式:HH:mm:ss
	 * 
	 */
	public static final int TIME = 7;

	/**
	 * 变量：日期格式化类型 - 格式:HH:mm
	 * 
	 */
	public static final int HM = 8;

	/**
	 * 变量：日期格式化类型 - 格式:HHmmss
	 * 
	 */
	public static final int LONG_TIME = 9;
	/**
	 * 变量：日期格式化类型 - 格式:HHmm
	 * 
	 */

	public static final int SHORT_TIME = 10;

	/**
	 * 变量：日期格式化类型 - 格式:yyyy-MM-dd HH:mm:ss
	 */
	public static final int DATE_TIME_LINE = 12;

	/**
	 * 时间转为字符串
	 * 
	 * @param date
	 * @param type
	 * @return
	 */
	public static String dateToStr(Date date, int type) {
		switch (type) {
		case DEFAULT:
			return dateToStr(date);
		case YM:
			return dateToStr(date, "yyyy/MM");
		case NO_SLASH:
			return dateToStr(date, "yyyyMMdd");
		case YMR_SLASH:
			return dateToStr(date, "yyyy-MM-dd");
		case YM_NO_SLASH:
			return dateToStr(date, "yyyyMM");
		case DATE_TIME:
			return dateToStr(date, "yyyy/MM/dd HH:mm:ss");
		case DATE_TIME_NO_SLASH:
			return dateToStr(date, "yyyyMMddHHmmss");
		case DATE_HM:
			return dateToStr(date, "yyyy/MM/dd HH:mm");
		case TIME:
			return dateToStr(date, "HH:mm:ss");
		case HM:
			return dateToStr(date, "HH:mm");
		case LONG_TIME:
			return dateToStr(date, "HHmmss");
		case SHORT_TIME:
			return dateToStr(date, "HHmm");
		case DATE_TIME_LINE:
			return dateToStr(date, "yyyy-MM-dd HH:mm:ss");
		default:
			throw new IllegalArgumentException("Type undefined : " + type);
		}
	}

	/**
	 * 时间转为字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateToStr(Date date, String pattern) {
		if (date == null || date.equals(""))
			return null;
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}

	/**
	 * 时间转为字符串 固定为yyyy/mm/dd格式
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateToStr(Date date) {
		return dateToStr(date, "yyyy/MM/dd");
	}

	/**
	 * 将一个时间戳转换成提示性时间字符串，如刚刚，1秒前
	 * 
	 * @param timeStamp
	 * @return
	 */
	public static String convertDateTimeToStr(LocalDateTime date) {
		long curTime = System.currentTimeMillis() / (long) 1000;
		long time = curTime - date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() / 1000;
		if (time >= 0) {
			if (time < 60 && time >= 0) {
				return "刚刚";
			} else if (time >= 60 && time < 3600) {
				return time / 60 + "分钟前";
			} else if (time >= 3600 && time < 3600 * 24) {
				return time / 3600 + "小时前";
			} else if (time >= 3600 * 24 && time < 3600 * 24 * 30) {
				return time / 3600 / 24 + "天前";
			} else if (time >= 3600 * 24 * 30 && time < 3600 * 24 * 30 * 12) {
				return time / 3600 / 24 / 30 + "个月前";
			} else if (time >= 3600 * 24 * 30 * 12) {
				return time / 3600 / 24 / 30 / 12 + "年前";
			} else {
				return "刚刚";
			}
		} else {
			time = 0 - time;
			if (time < 60 && time >= 0) {
				return "准备";
			} else if (time >= 60 && time < 3600) {
				return time / 60 + "分钟后";
			} else if (time >= 3600 && time < 3600 * 24) {
				return time / 3600 + "小时后";
			} else if (time >= 3600 * 24 && time < 3600 * 24 * 30) {
				return time / 3600 / 24 + "天后";
			} else if (time >= 3600 * 24 * 30 && time < 3600 * 24 * 30 * 12) {
				return time / 3600 / 24 / 30 + "个月后";
			} else if (time >= 3600 * 24 * 30 * 12) {
				return time / 3600 / 24 / 30 / 12 + "年后";
			} else {
				return "准备";
			}
		}
	}

}