package com.dany.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Timer {

	/**
	 * 格式化时间 ：如 20181018 -->2018-10-18
	 */
	public static String getFormatDate(String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyyMMdd").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = df.format(date);
		return dateString;
	}


	/**
	 * 获取当前时间
	 * 
	 * @return 当前时间：如：2014-10-01 13：14：00
	 */
	public static String getCurrentTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = df.format(date);
		return dateString;
	}


	/**
	 * 转换日期格式(2015-09-23 to 23/09)
	 * 
	 * @throws ParseException
	 */
	public static String formatDateAsDdMM(String date) throws ParseException {

		return new SimpleDateFormat("dd/MM").format(convertStringToDate(date));
	}
	
	/**
	 * 转换日期格式(2015-09 to 2015/09/01)
	 * 
	 * @throws ParseException
	 */
	public static String formatDateAsYYYYMMd(String date) throws ParseException {
		String temp = date.concat("-01");
		return new SimpleDateFormat("yyyy/MM/dd").format(convertStringToDate(temp));
	}

	/**
	 * 日期字符串转换成日期格式（2015-09-23 to date）
	 * 
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String date) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	}

	/**
	 * 日期字符串转换成日期格式（2015-09-23 12:01:12 to date）
	 * 
	 * @throws ParseException
	 */
	public static Date convertStringToDateTime(String date)
			throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
	}


	/**
	 * 获得前一天的日期
	 */
	public static Date getPreviousDay(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 获得前N天的日期
	 */
	public static Date getPreviousDay(Date date, int dateCount) {
		for (int i = 0; i < dateCount; i++) {
			date = getPreviousDay(date);
		}
		return date;
	}

	/**
	 * 使用参数Format格式化Date成字符串 2015-11-12
	 */
	public static String format(Date date) {
		return date == null ? " " : new SimpleDateFormat("yyyy-MM-dd")
				.format(date);
	}
	
	public static String format(String dateStr) throws ParseException {
		Date date = convertStringToDate(dateStr);
		return date == null ? " " : new SimpleDateFormat("yyyy-MM-dd")
				.format(date);
	}

	public static String formatMD(String date) throws ParseException {
		Date dt = convertStringToDate(date);
		return date == null ? " " : new SimpleDateFormat("MM-dd").format(dt);
	}

	/**
	 * 使用参数Format格式化Date成字符串
	 */
	public static String format(Date date, String pattern) {
		return date == null ? " " : new SimpleDateFormat(pattern).format(date);
	}

	//比较两个日期大小
	public static int compare_date(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
//				System.out.println("dt1 在dt2前");
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
//				System.out.println("dt1在dt2后");
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

}
