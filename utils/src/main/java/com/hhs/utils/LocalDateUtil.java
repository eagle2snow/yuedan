package com.hhs.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * LocalDateTime、LocalDate、LocalTime工具
 * 
 * @author pqr
 *
 */
public class LocalDateUtil {

	/**
	 * java.util.Date --> java.time.LocalDateTime
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDateTime UDateToLocalDateTime(Date date) {
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		return localDateTime;
	}

	/**
	 * java.util.Date --> java.time.LocalDate
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate UDateToLocalDate(Date date) {
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		LocalDate localDate = localDateTime.toLocalDate();
		return localDate;
	}

	/**
	 * java.util.Date --> java.time.LocalTime
	 * 
	 * @param date
	 * @return
	 */
	public static LocalTime UDateToLocalTime(Date date) {
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		LocalTime localTime = localDateTime.toLocalTime();
		return localTime;
	}

	/**
	 * java.time.LocalDateTime --> java.util.Date
	 * 
	 * @param localDateTime
	 * @return
	 */
	public static Date LocalDateTimeToUdate(LocalDateTime localDateTime) {
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDateTime.atZone(zone).toInstant();
		java.util.Date date = Date.from(instant);
		return date;
	}

	/**
	 * java.time.LocalDate --> java.util.Date
	 * 
	 * @param localDate
	 * @return
	 */
	public static Date LocalDateToUdate(LocalDate localDate) {
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
		java.util.Date date = Date.from(instant);
		return date;
	}

	/**
	 * java.time.LocalTime --> java.util.Date
	 * 
	 * @param localTime
	 * @return
	 */
	public static Date LocalTimeToUdate(LocalTime localTime) {
		LocalDate localDate = LocalDate.now();
		LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDateTime.atZone(zone).toInstant();
		java.util.Date date = Date.from(instant);
		return date;
	}

	/**
	 * 根据自定义时间格式字符串转LocalDateTime
	 * 
	 * @param time
	 *            时间字符串
	 * @param timeFormat
	 *            自定义时间格式
	 * @return
	 */
	public static LocalDateTime strToLocalDateTime(String time, String timeFormat) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(timeFormat);
		LocalDateTime localDateTime = LocalDateTime.parse(time, dtf);
		return localDateTime;
	}

	/**
	 * 根据自定义时间格式字符串转LocalDate
	 * 
	 * @param time
	 *            时间字符串
	 * @param timeFormat
	 *            自定义时间格式
	 * @return
	 */
	public static LocalDate strToLocalDate(String time, DateTimeFormatter timeFormat) {
		LocalDate localDate = LocalDate.parse(time, timeFormat);
		return localDate;
	}

	/**
	 * 获取今天最大时间
	 * 
	 * @return
	 */
	public static LocalDateTime getTodayMaxTime() {
		LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
		return localDateTime;
	}

	/**
	 * 获取一天最大时间
	 * 
	 * @return
	 */
	public static LocalDateTime getOnedayMaxTime(LocalDate localDate) {
		LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.MAX);
		return localDateTime;
	}

	/**
	 * 获取今天最小时间
	 * 
	 * @return
	 */
	public static LocalDateTime getTodayMinTime() {
		LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
		return localDateTime;
	}

	/**
	 * 获取一天最小时间
	 * 
	 * @return
	 */
	public static LocalDateTime getOnedayMinTime(LocalDate localDate) {
		LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.MIN);
		return localDateTime;
	}

	/**
	 * localDateTime转指定String格式
	 * 
	 * @param timeFormat
	 * @param localDateTime
	 * @return
	 */
	public static String localDateTimeToStr(DateTimeFormatter timeFormat, LocalDateTime localDateTime) {
		String time = localDateTime.format(timeFormat).toString();
		return time;
	}

	/**
	 * 以某天获取某周的开始时间
	 * 
	 * @return
	 */
	public static LocalDateTime getThisWeekStartTime(LocalDateTime time) {
		LocalDateTime sTime = null;
		for (long i = 1; i < 7; i++) {
			if (time.getDayOfWeek().getValue() != 1) {
				if (time.getDayOfWeek().getValue() - i == 1) {
					sTime = time.minusDays(i);
					sTime = LocalDateUtil.getOnedayMinTime(sTime.toLocalDate());
					break;
				}
			} else {
				sTime = LocalDateUtil.getOnedayMinTime(time.toLocalDate());
			}
		}
		return sTime;
	}

	/**
	 * 以某天获取某周的结束时间
	 * 
	 * @return
	 */
	public static LocalDateTime getThisWeekEndTime(LocalDateTime time) {
		LocalDateTime eTime = null;
		for (long i = 1; i < 7; i++) {
			if (time.getDayOfWeek().getValue() != 7) {
				if (time.getDayOfWeek().getValue() + i == 7) {
					eTime = time.plusDays(i);
					eTime = LocalDateUtil.getOnedayMaxTime(eTime.toLocalDate());
					break;
				}
			} else {
				eTime = LocalDateUtil.getOnedayMaxTime(time.toLocalDate());
				;
			}
		}
		return eTime;
	}

	/**
	 * LocalDateTime转数据库时间格式
	 * 
	 * @param time
	 * @return "str_to_date('2017-06-05 19:51:47','%Y-%m-%d %H:%i:%s')"
	 */
	public static String LocalDateToDbDateStr(LocalDateTime time) {
		StringBuffer sb = new StringBuffer();
		String date = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		sb.append(" str_to_date('" + date + "','%Y-%m-%d %H:%i:%s') ");
		return sb.toString();
	}

	/**
	 * LocalDateTime转查询数据库时间段
	 * 
	 * @param time
	 * @return "between str_to_date('2017-06-05 20:00:54','%Y-%m-%d %H:%i:%s') and
	 *         str_to_date('2017-06-05 20:00:54','%Y-%m-%d %H:%i:%s')"
	 */
	public static String LocalDateToDbDateStr(LocalDateTime sTime, LocalDateTime eTime) {
		StringBuffer sb = new StringBuffer();
		String sDate = sTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String eDate = eTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		sb.append(" between ");
		sb.append(" str_to_date('" + sDate + "','%Y-%m-%d %H:%i:%s') ");
		sb.append(" and ");
		sb.append(" str_to_date('" + eDate + "','%Y-%m-%d %H:%i:%s') ");
		return sb.toString();
	}

	/**
	 * 判断某个时间是否在一个时间段内
	 * 
	 * @param time
	 * @param sTime
	 * @param eTime
	 * @return
	 */
	public static boolean includeTime(LocalDateTime time, LocalDateTime sTime, LocalDateTime eTime) {
		boolean flag = false;
		if (time.isAfter(sTime) && time.isBefore(eTime)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 判断time是否在times的时间段内
	 * 
	 * @param time
	 *            "00:00"
	 * @param times
	 *            "00:00-07:00|13:00-19:00"
	 * @return
	 */
	public static boolean isContainTime(String time, String times) {
		String[] timeSlotArr = times.trim().split("\\|");
		LocalTime starsTime = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
		LocalTime endTime = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
		LocalTime validateTime = LocalTime.parse(time);
		boolean flag = false;
		v: for (int i = 0; i < timeSlotArr.length; i++) {
			String[] startAndEndTimeArr = timeSlotArr[i].split("-");
			for (int j = 0; j < startAndEndTimeArr.length; j++) {
				if (j % 2 == 0) {
					starsTime = LocalTime.parse(startAndEndTimeArr[j]);
				} else if (j % 2 == 1) {
					endTime = LocalTime.parse(startAndEndTimeArr[j]);
				}
				if (j % 2 == 1) {
					if ((validateTime.isAfter(starsTime) && validateTime.isBefore(endTime))
							|| validateTime.equals(starsTime) || validateTime.equals(endTime)) {
						flag = true;
						break v;
					}
				}
			}
		}
		return flag;
	}

	/**
	 * 判断一个时间是否包含在以今天开始的N天的范围内
	 * 
	 * @param date
	 *            判断时间
	 * @param dates
	 *            排除时间
	 * @param day
	 *            天数
	 * @return
	 */
	public static boolean isContainDate(Date date, String dates, Integer day) {
		boolean flag = false;
		LocalDate validateDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
		LocalDate nowLocalDate = LocalDate.now();
		if (dates.equals("")) {
			if ((validateDate.isAfter(nowLocalDate) && validateDate.isBefore(nowLocalDate.plusDays(day)))
					|| nowLocalDate.equals(validateDate) || nowLocalDate.plusDays(day).equals(validateDate)) {
				flag = true;
			}
		} else {
			if ((validateDate.isAfter(nowLocalDate) && validateDate.isBefore(nowLocalDate.plusDays(day)))
					|| nowLocalDate.equals(validateDate) || nowLocalDate.plusDays(day).equals(validateDate)) {
				String[] limitDate = dates.replace(" ", "").split("\\,");
				for (int i = 0; i < limitDate.length; i++) {
					if (validateDate.equals(LocalDate.parse(limitDate[i]))) {
						flag = false;
					} else {
						flag = true;
						break;
					}
				}
			}
		}
		return flag;
	}

	/**
	 * 判断LocalDate是否在口语星期时间段内
	 * 
	 * @param localDate
	 *            需要判断的日期
	 * @param speakTime
	 *            xx|xx(xx:星期一或周一或者星期1)如:周一至周三
	 * @param symbol
	 *            分割符
	 * @return LocalDate
	 */
	public static boolean speakTimeContainLocalDate(LocalDate localDate, String speakTime, String symbol) {
		boolean flag = false;
		String[] rangeDate = speakTime.trim().split(symbol);
		int sDateOfWeek = speakTimeToNum(rangeDate[0]);
		int eDateOfWeek = speakTimeToNum(rangeDate[1]);
		
		int nowWeek = localDate.getDayOfWeek().getValue();
		for (int i = sDateOfWeek; i <= eDateOfWeek; i++) {
			if (i == nowWeek) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * 判断LocalDate是否在包含该时间星期时间段内
	 * 
	 * @param localDate
	 *            需要判断的日期
	 * @param sDayOfWeek
	 *            开始星期
	 * @param eDayOfWeek
	 *            结束星期
	 * @return LocalDate
	 */
	public static boolean dayOfWeekRangeContainLocalDate(LocalDate localDate, int sDayOfWeek, int eDayOfWeek) {
		int nowWeek = localDate.getDayOfWeek().getValue();
		if (eDayOfWeek<sDayOfWeek) {
			for (int i = eDayOfWeek; i < sDayOfWeek; i++) {
				if (nowWeek == i&&i != eDayOfWeek) {
					return false;
				}
			}
			return true;
		}
		for (int i = sDayOfWeek; i <= eDayOfWeek; i++) {
			if (i == nowWeek) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 口语星期转数字
	 * 
	 * @param speakTime
	 *            (可以是星期一或周一或者星期1)
	 * @return
	 */
	public static int speakTimeToNum(String speakTime) {
		speakTime = speakTime.replace(" ", "");
		String week = speakTime.substring(speakTime.length() - 1);
		int weekValue = -1;
		week = week.trim();
		if ("一".equals(week) || "1".equals(week)) {
			weekValue = 1;
		} else if ("二".equals(week) || "2".equals(week)) {
			weekValue = 2;
		} else if ("三".equals(week) || "3".equals(week)) {
			weekValue = 3;
		} else if ("四".equals(week) || "4".equals(week)) {
			weekValue = 4;
		} else if ("五".equals(week) || "5".equals(week)) {
			weekValue = 5;
		} else if ("六".equals(week) || "6".equals(week)) {
			weekValue = 6;
		} else if ("天".equals(week) || "日".equals(week) || "七".equals(week) || "7".equals(week)) {
			weekValue = 7;
		}
		return weekValue;
	}

	/**
	 * 获取今天范围内递增时间
	 * 
	 * @param sTime
	 *            开始时间
	 * @param eTime
	 *            结束时间
	 * @param interval
	 *            间隔
	 * @return
	 */
	public static List<LocalTime> rangeUnfoldedTime(LocalTime sTime, LocalTime eTime, int interval) {
		List<LocalTime> range = new ArrayList<>();
		range.add(sTime);
		LocalTime tempTime = sTime;
		if (eTime.isBefore(sTime)) {
			eTime = LocalTime.MAX.minusMinutes(interval).plusNanos(1);
		}
		for (;;) {
			tempTime = tempTime.plusMinutes(interval);
			if (tempTime.isBefore(eTime)) {
				range.add(tempTime);
			} else {
				range.add(eTime);
				break;
			}
		}
		return range;
	}
	
	public static void main(String[] args) {
		
		LocalTime a = LocalTime.parse("10:30");
		LocalTime b = LocalTime.parse("07:00");
		List<LocalTime> times = LocalDateUtil.rangeUnfoldedTime(a, b, 15);
		Map<LocalTime,Integer> map = new ConcurrentHashMap<>();
		times.forEach(t->map.put(t, 0));
		System.out.println(map);
	}
}
