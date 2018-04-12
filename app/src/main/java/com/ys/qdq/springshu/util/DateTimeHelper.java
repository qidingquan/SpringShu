/*
 * DateTimeHelper.java	2004-6-17
 *
 * 版权所有: 自由思考组织(FTO)软件团队 2000-2005, 保留所有权利.
 * 这个软件是自由思考组织(FTO)软件团队开发的，如果要使用这个软件，请首先阅读并接受许可协议。
 *
 * Copyright 2000-2005 FTO Software Team, Inc. All Rights Reserved.
 * This software is the proprietary information of FTO Software Team, Inc.
 * Use is subject to license terms.
 *
 * FTO站点：http://www.free-think.org
 */
package com.ys.qdq.springshu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期时间类型的工具类，提供对日期和时间基于毫秒及以上精度的格式化方法、
 * 运算方法、比较方法等。注意:大部分对日期对象(java.util.Date)操作的方法,
 * 不会修改原日期对象,而以一个新的日期对象返回。
 * 
 * 
 * <p><pre><b>
 * 历史更新记录:</b>
 * 2004-6-17  创建此类型
 * 2005-9-30  修改方法：parseToDate(),去掉了对年份从(1970-9999)这个范围的限制。抛出异常:IllegalArgumentException(),JThinkRuntimeException()
 * 2005-10-2  修改方法: 其它方法,抛出异常:IllegalArgumentException(),JThinkRuntimeException()
 * 2005-10-2  增加方法: addTime(Date d, double times, int type)
 * 2005-10-2  增加方法: addSystemTime()
 * 2005-10-2  修改方法, 对于所有以日期对象类型java.util.Date为参数的方法,如果日期为null,都抛出异常:IllegalArgumentException()
 * 
 * </pre></p>
 * 
 * 
 * @author   abnerchai,wenjian
 * @version  1.0
 * @since    JThink 1.0
 * 
 */

public final class DateTimeHelper {

	/**
	 * 把时间格式化成如：2002-08-03 8:26:30.400 am 格式的字符串
	 */
	public final static String FMT_yyyyMMddHHmmssSa_12 = "yyyy-MM-dd KK:mm:ss.S a";

	/**
	 * 把时间格式化成如：2002-08-03 8:26:16 am 格式的字符串
	 */
	public final static String FMT_yyyyMMddHHmmssa_12 = "yyyy-MM-dd KK:mm:ss a";

	/**
	 * 把时间格式化成如：2002-08-03 8:26 am 格式的字符串
	 */
	public final static String FMT_yyyyMMddHHmma_12 = "yyyy-MM-dd KK:mm a";

	/**
	 * 把时间格式化成如：2002-08-03 8 am 格式的字符串
	 */
	public final static String FMT_yyyyMMddHHa_12 = "yyyy-MM-dd KK a";

	/**
	 * 把时间格式化成如：2002-07-05 am 格式的字符串
	 */
	public final static String FMT_yyyyMMdda_12 = "yyyy-MM-dd a";

	/**
	 * 把时间格式化成如：2002-08-03 08:26:30.400 格式的字符串
	 */
	public final static String FMT_yyyyMMddHHmmssS = "yyyy-MM-dd HH:mm:ss.S";

	/**
	 * 把时间格式化成如：2002-08-03 08:26:16 格式的字符串
	 */
	public final static String FMT_yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 把时间格式化成如：2002-08-03 08:26 格式的字符串
	 */
	public final static String FMT_yyyyMMddHHmm = "yyyy-MM-dd HH:mm";

	/**
	 * 把时间格式化成如：2002-08-03 08 格式的字符串
	 */
	public final static String FMT_yyyyMMddHH = "yyyy-MM-dd HH";

	/**
	 * 把时间格式化成如：2002-07-05 格式的字符串
	 */
	public final static String FMT_yyyyMMdd = "yyyy-MM-dd";

	/**
	 * 把时间格式化成如：12:08 PM(下午) 格式的字符串
	 */
	public final static String FMT_HHmmA_12 = "KK:mm a";

	/**
	 * 把时间格式化成如：0:55 AM上午, CST 格式的字符串
	 */
	public final static String FMT_HHmmAz_12 = "KK:mm a,z";

	/**
	 * 把时间格式化成如：0:56 AM上午, 中国标准时间 格式的字符串
	 */
	public final static String FMT_HHmmAzzzz_12 = "KK:mm a,zzzz";

	/**
	 * 把时间格式化成如：12:08:23 am 格式的字符串
	 */
	public final static String FMT_HHmmssA_12 = "KK:mm:ss a";

	/**
	 * 把时间格式化成如：0:55:33 AM上午, CST 格式的字符串
	 */
	public final static String FMT_HHmmssAz_12 = "KK:mm:ss a,z";

	/**
	 * 把时间格式化成如：0:56:23 AM上午, 中国标准时间 格式的字符串
	 */
	public final static String FMT_HHmmssAzzzz_12 = "KK:mm:ss a,zzzz";

	/**
	 * 把时间格式化成如：22:04:45 格式的字符串
	 */
	public final static String FMT_HHmmss = "HH:mm:ss";

	/**
	 * 把时间格式化成如：22:04:45.824 格式的字符串
	 */
	public final static String FMT_HHmmssS = "HH:mm:ss.S";

	/**
	 * 把时间格式化成如：22:04 格式的字符串
	 */
	public final static String FMT_HHmm = "HH:mm";

	/**
	 * 把时间格式化成如：22:04,CST 格式的字符串
	 */
	public final static String FMT_HHmmz = "HH:mm,z";

	/**
	 * 把时间格式化成如：22:04,中国标准时间 格式的字符串
	 */
	public final static String FMT_HHmmzzzz = "HH:mm,zzzz";

	/**
	 * 把时间格式化成如：Sun,Nov 14,'2004 格式的字符串
	 */
	public final static String FMT_WWMMDDYY_EN = "EEE,MMM d,''yyyy";

	/**
	 * 把时间格式化成如：星期日,2004年十一月14号 格式的字符串
	 */
	public final static String FMT_WWMMDDYY_CN = "EEE,yyyy年MMMd号";

	/**
	 * 把时间格式化成如：Sun,Nov 14,'2004 格式的字符串
	 */
	public final static String FMT_MMDDYY_EN = "MMM d,''yyyy";

	/**
	 * 把时间格式化成如：星期日,2004年十一月14号 格式的字符串
	 */
	public final static String FMT_MMDDYY_CN = "yyyy年MMMd号";

	/**
	 * 把时间格式化成如：星期几 格式的字符串,即可获得该日这个时间是星期几
	 */
	public final static String FMT_WW = "EEE";

	/**
	 *常用的格式化时间的格式组，用于本类中格式化字符串成时间型
	 */
	private final static String[] formatStr ={
			FMT_yyyyMMddHHmmssS,
			FMT_yyyyMMddHHmmss,
			FMT_yyyyMMddHHmm,
			FMT_yyyyMMddHH,
			FMT_yyyyMMdd,
			FMT_HHmmss,
			FMT_HHmmssS,
			FMT_HHmm,
			FMT_HHmmz,
			FMT_HHmmzzzz,
			FMT_yyyyMMddHHmmssSa_12,
			FMT_yyyyMMddHHmmssa_12,
			FMT_yyyyMMddHHmma_12,
			FMT_yyyyMMddHHa_12,
			FMT_yyyyMMdda_12,
			FMT_HHmmA_12,
			FMT_HHmmAz_12,
			FMT_HHmmAzzzz_12,
			FMT_HHmmssA_12,
			FMT_HHmmssAz_12,
			FMT_HHmmssAzzzz_12
	};


	/**
	 *
	 *私有化构造器，使得不能产生该类对象，类中所有的方法均为静态方法
	 *
	 */
	private DateTimeHelper() {
	}

	/**
	 * 根据给出的Date值和格式串采用操作系统的默认所在的国家风格来格式化时间，并返回相应的字符串
	 * @param date
	 * @param formatStr
	 * @return 如果为null，返回字符串""
	 */
	public static String formatDateTimetoString(Date date, String formatStr) {
		String reStr = "";
		if (date == null || formatStr == null || formatStr.trim().length() < 1) {
			return reStr;
		}
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(formatStr);
		reStr = sdf.format(date);
		return reStr == null ? "" : reStr;
	}

	/**
	 * 根据给出的Date值和格式串采用给定的国家所在的国家风格来格式化时间，并返回相应的字符串
	 * @param date 日期对象
	 * @param formatStr 日期格式
	 * @return 如果为null，返回字符串""
	 */
	public static String formatDateTimetoString(Date date, String formatStr, Locale locale) {
		String reStr = "";
		if (date == null || formatStr == null || locale == null || formatStr.trim().length() < 1) {
			return reStr;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr, locale);
		reStr = sdf.format(date);
		return reStr == null ? "" : reStr;
	}

	/**
	 * 根据给出的Date值字符串和格式串采用操作系统的默认所在的国家风格来格式化时间，并返回相应的字符串
	 * @param dateStr 日期串
	 * @param formatStr 日期格式
	 * @return 如果为null，返回""
	 * @throws Exception
	 */
	public static String formatDateTimetoString(String dateStr, String formatStr) throws Exception {
		String dStr = "";
		if (dateStr != null && dateStr.trim().length() > 0 && formatStr != null && formatStr.trim().length() > 0) {
			dStr = formatDateTimetoString(parseToDate(dateStr), formatStr);
		}
		return dStr;
	}

	/**
	 * 根据给出的Date值字符串和格式串采用指定国家的风格来格式化时间，并返回相应的字符串
	 * @param dateStr 日期串
	 * @param formatStr 日期格式
	 * @return 如果为null，返回""
	 * @throws Exception
	 */
	public static String formatDateTimetoString(String dateStr, String formatStr, Locale locale) throws Exception {
		String dStr = "";
		if (dateStr != null && dateStr.trim().length() > 0 && formatStr != null && formatStr.trim().length() > 0 && locale != null) {
			dStr = formatDateTimetoString(parseToDate(dateStr, locale), formatStr, locale);
		}
		return dStr;
	}

	/**
	 * 按指定的格式和操作系统默认国家的风格把给定的日期字符串格式化为一个Date型日期
	 * @param dateTimeStr
	 * @param formatStr
	 * @return java.util.Date类型对象
	 * @throws ParseException
	 */
	public static Date parseToDate(String dateTimeStr, String formatStr) throws ParseException {
		if (dateTimeStr == null || formatStr == null || dateTimeStr.trim().length() < 1 || formatStr.trim().length() < 1) {
			throw new IllegalArgumentException("参数dateTimeStr、formatStr不能是null或空格串!");
		}

		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		try {
			return sdf.parse(dateTimeStr);
		} catch (ParseException e) {
			throw e;			
		}
	}

	/**
	 * 按指定的格式和指定国家的风格把给定的日期字符串格式化为一个Date型日期
	 * @param dateTimeStr
	 * @param formatStr
	 * @param locale
	 * @return java.util.Date类型对象
	 * @throws ParseException
	 */
	public static Date parseToDate(String dateTimeStr, String formatStr, Locale locale) throws ParseException {
		if (dateTimeStr != null && formatStr != null && locale != null && dateTimeStr.trim().length() > 0 && formatStr.trim().length() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat(formatStr, locale);
			try {
				return sdf.parse(dateTimeStr);
			} catch (ParseException e) {
				throw e;		
			}
		}else{
			throw new IllegalArgumentException("参数dateTimeStr、formatStr、locale不能是null或空格串!");
		}

	}

	/**
	 * 按操作系统默认国家的风格把给定的日期字符串格式化为一个Date型日期
	 * @param dateTimeStr
	 * @return java.util.Date类型对象
	 * @throws Exception
	 */
	public static Date parseToDate(String dateTimeStr) throws RuntimeException {
		if (dateTimeStr == null || dateTimeStr.trim().length() < 1) {
			throw new IllegalArgumentException("参数dateTimeSt不能是null或空格串!");
		}
		int formatStrLength = formatStr.length;
		int i = 0;
		
		for (i = 0; i < formatStrLength; i++) {
			SimpleDateFormat sdf = new SimpleDateFormat(formatStr[i]);
			try {
				return sdf.parse(dateTimeStr);
			} catch (ParseException e) {}
		}
		throw new RuntimeException("日期格式不正确!");
	}

	/**
	 * 根据给出的年月和日返回一个日期型的对象
	 * @param year 年 
	 * @param month 月 ，1到12
	 * @param day 日 ，1到31
	 * @return java.util.Date类型对象
	 * @throws Exception
	 */
	public static Date parseToDate(int year, int month, int day) throws Exception {
		if(month<1 || month>12 || day<1 || day>31){
			throw new IllegalArgumentException("参数不正确!");
		}
		String yearStr = String.valueOf(year);
		String monthStr = String.valueOf(month);
		String dayStr = String.valueOf(day);
		
		return parseToDate(yearStr+"-"+monthStr+"-"+dayStr);

	}
	/**
	 * 根据给出的年月日、时分秒、返回一个对应的Date型对象
	 * @param year 年
	 * @param month 月 ，1到12
	 * @param day 日 ，1到31
	 * @param h 小时，从0到23
	 * @param m 分，从0到60
	 * @param s 秒，从0到60
	 * @return java.util.Date类型对象
	 * @throws Exception
	 */
	public static Date parseToDate(int year, int month, int day, int h, int m, int s) throws Exception {
		if(month<1 || month>12 || day<1 || day>31 || h<0 || h>23 || m<0 || m>60 || s<0 || s>60){
			throw new IllegalArgumentException("参数不正确!");
		}
		String yearStr = String.valueOf(year);
		String monthStr = String.valueOf(month);
		String dayStr = String.valueOf(day);
		String hStr = String.valueOf(h);
		String mStr = String.valueOf(m);
		String sStr = String.valueOf(s);

		return parseToDate(yearStr+"-"+monthStr+"-"+dayStr+" "+hStr+":"+mStr+":"+sStr);


	}

	/**
	 * 按指定国家的风格把给定的日期字符串格式化为一个Date型日期
	 * @param dateTimeStr
	 * @return java.util.Date类型对象
	 * @throws Exception
	 */
	public static Date parseToDate(String dateTimeStr, Locale locale) throws Exception {
		if (dateTimeStr == null || dateTimeStr.trim().length() < 1 || locale == null) {
			throw new IllegalArgumentException("参数dateTimeSt、locale不能是null或空格串!");
		}
		int formatStrLength = formatStr.length;
		int i = 0;
		for (i = 0; i < formatStrLength; i++) {
			SimpleDateFormat sdf = new SimpleDateFormat(formatStr[i], locale);
			try {
				return sdf.parse(dateTimeStr);
			} catch (ParseException e) {}
		}
		throw new Exception("日期格式不正确!");
	}

	/**
	 * 将给定的日期时间字符串按操作系统默认的国家风格格式化成"yyyy-MM-dd HH:mm:ss"格式的日期时间串;
	 * @param dateTimeStr
	 * @return 如果为null，返回""
	 * @throws Exception
	 */
	public static String formatDateTimetoString(String dateTimeStr) throws Exception {
		return formatDateTimetoString(dateTimeStr, FMT_yyyyMMddHHmmss);
	}

	/**
	 * 将给定的日期时间字符串按指定国家的风格格式化成"yyyy-MM-dd HH:mm:ss"格式的日期时间串;
	 * @param dateTimeStr
	 * @param locale
	 * @return 如果为null，返回""
	 * @throws Exception
	 */
	public static String formatDateTimetoString(String dateTimeStr, Locale locale) throws Exception {
		return formatDateTimetoString(dateTimeStr, FMT_yyyyMMddHHmmss, locale);
	}

	/**
	 * 将给定的日期时间按操作系统默认的国家内格格式化成"yyyy-MM-dd HH:mm:ss"格式的日期时间串;
	 * @param dateTime
	 * @return 如果为null，返回""
	 */
	public static String formatDateTimetoString(Date dateTime) {
		return formatDateTimetoString(dateTime, FMT_yyyyMMddHHmmss);
	}

	/**
	 * 将给定的日期时间按指定国家的风格格式化成"yyyy-MM-dd HH:mm:ss"格式的日期时间串;
	 * @param dateTime
	 * @param locale
	 * @return 如果为null，返回""
	 */
	public static String formatDateTimetoString(Date dateTime, Locale locale) {
		return formatDateTimetoString(dateTime, FMT_yyyyMMddHHmmss, locale);
	}

	/**
	 * 将给定的日期字符串按操作系统默认的国家风格格式化成"yyyy-MM-dd"格式的日期串;
	 * @param dateStr 日期串
	 * @return 如果为null，返回""
	 * @throws Exception
	 */
	public static String formatDatetoString(String dateStr) throws Exception {
		return formatDateTimetoString(dateStr, FMT_yyyyMMdd);
	}

	/**
	 * 将给定的日期字符串按指定国家的风格格式化成"yyyy-MM-dd"格式的日期串;
	 * @param dateStr 日期串
	 * @param locale Locale
	 * @return 如果为null，返回""
	 * @throws Exception
	 */
	public static String formatDatetoString(String dateStr, Locale locale) throws Exception {
		return formatDateTimetoString(dateStr, FMT_yyyyMMdd, locale);
	}

	/**
	 * 将给定的日期按指定操作系统默认国家的风格格式化成"yyyy-MM-dd"格式的日期串;
	 * @param d 日期对象
	 * @return 如果为null，返回""
	 */
	public static String formatDatetoString(Date d) {
		return formatDateTimetoString(d, FMT_yyyyMMdd);
	}

	/**
	 * 将给定的日期按指定国家的风格格式化成"yyyy-MM-dd"格式的日期串;
	 * @param d 日期对象
	 * @param locale Locale
	 * @return 如果为null，返回""
	 */
	public static String formatDatetoString(Date d, Locale locale) {
		return formatDateTimetoString(d, FMT_yyyyMMdd, locale);
	}

	/**
	 * 将给定的日期时间字符串按操作系统默认的国家风格格式化成"HH:mm:ss"格式的时间串;
	 * @param dateTimeStr
	 * @return 如果为null，返回""
	 * @throws Exception
	 */
	public static String formatTimetoString(String dateTimeStr) throws Exception {
		return formatDateTimetoString(dateTimeStr, FMT_HHmmss);
	}

	/**
	 * 将给定的日期时间字符串按指定国家的风格格式化成"HH:mm:ss"格式的时间串;
	 * @param dateTimeStr
	 * @param locale
	 * @return 如果为null，返回""
	 * @throws Exception
	 */
	public static String formatTimetoString(String dateTimeStr, Locale locale) throws Exception {
		return formatDateTimetoString(dateTimeStr, FMT_HHmmss, locale);
	}

	/**
	 * 将给定的日期时间按指定操作系统默认国家的风格格式化成"HH:mm:ss"格式的时间串;
	 * @param dateTimeStr
	 * @return 如果为null，返回""
	 */
	public static String formatTimetoString(Date dateTimeStr) {
		return formatDateTimetoString(dateTimeStr, FMT_HHmmss);
	}

	/**
	 * 将给定的日期时间按指定国家的风格格式化成"HH:mm:ss"格式的时间串;
	 * @param dateTimeStr
	 * @param locale
	 * @return 如果为null，返回""
	 */
	public static String formatTimetoString(Date dateTimeStr, Locale locale) {
		return formatDateTimetoString(dateTimeStr, FMT_HHmmss, locale);
	}

	/**
	 * 返回一个时间的年份整数
	 * @param d
	 * @return  年份
	 */
	public static int getYearOfDate(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 返回一个时间的月份整数
	 * @param d
	 * @return 月份
	 */
	public static int getMonthOfYear(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 返回一个时间的天份整数，是这个月的第几天
	 * @param d
	 * @return 天份
	 */
	public static int getDayOfMonth(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 返回一个时间的天份整数，是这个年份的第几天
	 * @param d
	 * @return 天份
	 */
	public static int getDayOfYear(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 返回一个时间的天份整数，是这个周的第几天
	 * @param d
	 * @return 天份
	 */
	public static int getDayOfWeek(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 返回一个时间的周的整数，是这个月的第几周
	 * @param d
	 * @return 周
	 */
	public static int getWeekOfMonth(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.WEEK_OF_MONTH);
	}

	/**
	 * 返回一个时间的周的整数，是这个年份的第几周
	 * @param d
	 * @return 周
	 */
	public static int getWeekOfYear(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 返回该时间所对应的在一天中的小时数的整数，如当前(Date now)是下午3点，返回为15
	 * @param d
	 * @return 小时
	 */
	public static int getHoursOfDay(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		return hours;
	}

	/**
	 * 返回该时间所对应的在一天中的小时数的整数(采用12小时制)，如当前(Date now)是下午3点，返回为3
	 * @param d
	 * @return 小时
	 */
	public static int getHoursOfDay12(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int hours = calendar.get(Calendar.HOUR);
		return hours;
	}


	/**
	 * 返回该时间所对应的分钟数中的整数，如now是15点14分，则返回14
	 * @param d
	 * @return 分钟
	 */
	public static int getMinutesOfHour(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int minutes = calendar.get(Calendar.MINUTE);

		return minutes;
	}

	/**
	 * 返回该时间所对应的秒数中的整数,如now是15点14分34秒，则返回34
	 * @param d
	 * @return 秒
	 */
	public static int getSecondsOfMinute(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int seconds = calendar.get(Calendar.SECOND);

		return seconds;
	}

	/**
	 * 返回该时间所对应的毫秒数中的整数,如now是15点14分34秒470毫秒，则返回470
	 * @param d
	 * @return 毫秒
	 */
	public static int getMillisecondsOfSecond(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int millisecond = calendar.get(Calendar.MILLISECOND);

		return millisecond;
	}

	/**
	 * 返回该时间相对于1970年1月1日开始计算的对应的毫秒数
	 * @param d
	 * @return 毫秒数
	 */
	public static long getTime(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		return d.getTime();
	}

	/**
	 * 比较两个时间的先后顺序。
	 * 如果时间d1在d2之前，返回1,
	 * 如果时间d1在d2之后，返回-1，
	 * 如果二者相等，返回0
	 * @param d1
	 * @param d2
	 * @return 
	 *          如果时间d1在d2之前，返回1,
	 *          如果时间d1在d2之后，返回-1，
	 *          如果二者相等，返回0
	 */
	public static int compareTwoDate(Date d1, Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}

		long dI1 = d1.getTime();
		long dI2 = d2.getTime();

		if(dI1>dI2){
			return -1;
		}else if(dI1<dI2){
			return 1;
		}else {
			return 0;
		}

	}
	/**
	 * 返回两个日期之间的毫秒数的差距
	 * @param d1
	 * @param d2
	 * @return 二者至1970年1.1后的毫秒数的差值
	 */
	public static long getMillisecondsOfTwoDate(Date d1, Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}
		long dI1 = d1.getTime();
		long dI2 = d2.getTime();
		return (dI1-dI2);
	}

	/**
	 * 获得两个日期之间相差的秒数
	 * @param d1
	 * @param d2
	 * @return 两日期之间相差的秒数
	 */
	public static double getSecondsOfTwoDate(Date d1, Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}
		long i = getMillisecondsOfTwoDate(d1,d2);

		return (double)i/1000;
	}

	/**
	 * 获得两个日期之间相差的分钟数
	 * @param d1
	 * @param d2
	 * @return 两日期之间相差的分钟数
	 */
	public static double getMinutesOfTwoDate(Date d1, Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}
		long millions = getMillisecondsOfTwoDate(d1,d2);
		return (double)millions/60/1000;
	}

	/**
	 * 获得两个日期之间相差的小时数
	 * @param d1
	 * @param d2
	 * @return 两日期之间相差的小时数
	 */
	public static double getHoursOfTwoDate(Date d1, Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}
		long millions = getMillisecondsOfTwoDate(d1,d2);
		return (double)millions/60/60/1000;
	}

	/**
	 * 获得两个日期之间相差的天数
	 * @param d1
	 * @param d2
	 * @return 两日期之间相差的天数
	 */
	public static double getDaysOfTwoDate(Date d1, Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}
		long millions = getMillisecondsOfTwoDate(d1,d2);
		return (double)millions/24/60/60/1000;
	}

  /**
   * 把给定的时间加上指定的时间值，可以为负。
   * @param d 日期对象
   * @param times 时间值
   * @param type 类型，
   *           Calendar.MILLISECOND,毫秒<BR>
   *           Calendar.SECOND,秒<BR>
   *           Calendar.MINUTE,分钟<BR>
   *           Calendar.HOUR,小时<BR>
   *           Calendar.DATE,日<BR>
   * @return 如果d为null，返回null
   */
  public static Date addTime(Date d, double times, int type) {
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
	  long qv = 1;
	  switch(type){
	    case Calendar.MILLISECOND : qv = 1;break;
	    case Calendar.SECOND : qv = 1000;break;
	    case Calendar.MINUTE : qv = 1000*60;break;
	    case Calendar.HOUR : qv = 1000*60*60;break;
	    case Calendar.DATE : qv = 1000*60*60*24;break;
	    default:
	      throw new RuntimeException("时间类型不正确！type＝"+type);
      }
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(d);
      long milliseconds = (long) Math.round(Math.abs(times) * qv);
      if(times>0){
        for (; milliseconds > 0; milliseconds -= 2147483647) {
          if (milliseconds > 2147483647) {
            calendar.add(Calendar.MILLISECOND, 2147483647);
          }
          else {
            calendar.add(Calendar.MILLISECOND, (int) milliseconds);
          }
        }
      }else{
        for (; milliseconds > 0; milliseconds -= 2147483647) {
          if (milliseconds > 2147483647) {
            calendar.add(Calendar.MILLISECOND, -2147483647);
          }
          else {
            calendar.add(Calendar.MILLISECOND, -(int) milliseconds);
          }
        }
      }
      return calendar.getTime();
  }


	/**
	 * 把给定的时间加上指定的年份，可以为负, 返回新的被加上了年份的日期对象,不影响参数日期对象值
	 * @param d
	 * @param years
	 * @return 日期对象
	 */
	public static Date addYears(Date d, int years) {
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.YEAR, years);
		return calendar.getTime();
	}


	/**
	 * 把给定的时间加上指定的月份，可以为负
	 * @param d
	 * @param months
	 * @return  日期对象
	 */
	public static Date addMonths(Date d, int months) {
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}
	/**
	 * 把给定的时间加上指定的天数，可以为负
	 * @param d 日期对象
	 * @param days
	 * @return 日期对象
	 */
	public static Date addDays(Date d, int days) {
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.HOUR, days * 24);
		return calendar.getTime();
	}

	/**
	 * 把给定的时间加上指定的小时，可以为负
	 * @param d 日期对象
	 * @param hours
	 * @return 日期对象
	 */
	public static Date addHours(Date d, int hours) {
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.HOUR, hours);
		return calendar.getTime();
	}
	/**
	 * 把给定的时间加上指定的分钟，可以为负
	 * @param d
	 * @param minutes
	 * @return 日期对象
	 */
	public static Date addMinutes(Date d, int minutes) {
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.MINUTE, minutes);
		return calendar.getTime();
	}
	/**
	 * 把给定的时间加上指定的秒数，可以为负
	 * @param d
	 * @param seconds
	 * @return 日期对象
	 */
	public static Date addSeconds(Date d, int seconds) {
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.SECOND, seconds);
		return calendar.getTime();
	}
	/**
	 * 把给定的时间加上指定的毫秒数，可以为负
	 * @param d
	 * @param milliseconds
	 * @return 日期对象
	 */
	public static Date addMilliseconds(Date d, int milliseconds) {
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.MILLISECOND, milliseconds);
		return calendar.getTime();
	}

	/**
	 * 设置一个日期对象的年份是新的给定的年份
	 * @param d 需要设定的日期对象
	 * @param year 新的年份
	 * @return 日期对象
	 */
	public static Date setYearOfDate(Date d, int year){
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.YEAR,year);
		return calendar.getTime();
	}

	/**
	 * 设置一个日期对象的月份是新的给定的月份
	 * @param d 需要设定的日期对象
	 * @param month 新的月份
	 * @return 新日期对象
	 */
	public static Date setMonthOfDate(Date d, int month){
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.MONTH,month);
		return calendar.getTime();
	}

	/**
	 * 设置一个日期对象的天是新的给定的天
	 * @param d 需要设定的日期对象
	 * @param day 新的天
	 * @return 新日期对象
	 */
	public static Date setDayOfDate(Date d, int day){
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.DAY_OF_MONTH,day);
		return calendar.getTime();
	}

	/**
	 * 设置一个日期对象的小时是新的给定的小时
	 * @param d 需要设定的日期对象
	 * @param hour 新的小时数
	 * @return 新日期对象
	 */
	public static Date setHourOfDate(Date d, int hour){
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.HOUR_OF_DAY,hour);
		return calendar.getTime();
	}

	/**
	 * 设置一个日期对象的分钟是新的给定的分钟数
	 * @param d 需要设定的日期对象
	 * @param minute 新的分钟数
	 * @return 新日期对象
	 */
	public static Date setMinuteOfDate(Date d, int minute){
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.MINUTE,minute);
		return calendar.getTime();
	}

	/**
	 * 设置一个日期对象的秒数是新的给定的分钟数
	 * @param d 需要设定的日期对象
	 * @param second 新的秒数
	 * @return 新日期对象
	 */
	public static Date setSecondOfDate(Date d, int second){
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.SECOND,second);
		return calendar.getTime();
	}

	/**
	 * 设置一个日期对象的毫秒数是新的给定的分钟数
	 * @param d 需要设定的日期对象
	 * @param millisecond 新的毫秒数
	 * @return 新日期对象
	 */
	public static Date setMillisecondOfDate(Date d, int millisecond){
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.MILLISECOND,millisecond);
		return calendar.getTime();
	}
//	/**
//	 * 返回一个日期型的对应的中文描述如1999-09-06 返回:一九九九年九月六号
//	 * @param d 被格式化的日期对象
//	 * @return 返回被格式化后的中文字符串,如1999-09-06 返回:一九九九年九月六号
//	 */
//	public static String formateDateToCNString(Date d){
//		if (d == null){
//			throw new IllegalArgumentException("参数d不能是null对象!");
//		}
//		String re1 = formatDateTimetoString(d,FMT_MMDDYY_CN,Locale.CHINA);
//
//		String year = re1.substring(0,4);
//
//		String day = re1.substring(re1.indexOf("月")+1,re1.indexOf("号"));
//		String re2 = StringHelper.replace(re1,year,NumberHelper.getCNStringOfNumber(year));
//		String re3 = StringHelper.replace(re2,day,NumberHelper.getCNStringOfNumber(day));
//		return re3;
//
//	}
//	/**
//	 * 返回一个日期型字符串的对应的中文描述如1999-09-06 返回:一九九九年九月六号
//	 * @param d 被格式化的日期对象
//	 * @return 返回被格式化后的中文字符串,如1999-09-06 返回:一九九九年九月六号
//	 * @throws Exception
//	 */
//	public static String formateDateToCNString(String d) throws Exception{
//		if (d == null){
//			throw new IllegalArgumentException("参数d不能是null对象!");
//		}
//		String re1 = formatDateTimetoString(d,FMT_MMDDYY_CN,Locale.CHINA);
//
//		String year = re1.substring(0,4);
//
//		String day = re1.substring(re1.indexOf("月")+1,re1.indexOf("号"));
//
//		String re2 = StringHelper.replace(re1,year,NumberHelper.getCNStringOfNumber(year));
//		String re3 = StringHelper.replace(re2,day,NumberHelper.getCNStringOfNumber(day));
//		return re3;
//
//	}
//
//	/**
//	 * 返回一个日期型的对应的中文描述如1999-09-06 18:30:20 返回:一九九九年九月六号十八点三十分二十秒
//	 * @param d 被格式化的日期对象
//	 * @return 返回被格式化后的中文字符串,如1999-09-06 18:30:20 返回:一九九九年九月六号十八点三十分二十秒
//	 *
//	 */
//	public static String formateDateTimeToCNString(Date d){
//		if (d == null){
//			throw new IllegalArgumentException("参数d不能是null对象!");
//		}
//		String re1 = formatDateTimetoString(d,FMT_MMDDYY_CN,Locale.CHINA);
//		String year = re1.substring(0,4);
//
//		String day = re1.substring(re1.indexOf("月")+1,re1.indexOf("号"));
//
//		String re2 = StringHelper.replace(re1,year,NumberHelper.getCNStringOfNumber(year));
//		String re3 = StringHelper.replace(re2,day,NumberHelper.getCNStringOfNumber(day));
//
//		String re1time = formatDateTimetoString(d,FMT_HHmmss,Locale.CHINA);
//		int pos = re1time.indexOf(":");
//		String re2time = re1time.substring(0,pos) + "点" + re1time.substring(pos+1);
//		String hour = re1time.substring(0,2);
//		String minute = re1time.substring(3,5);
//		String second = re1time.substring(6);
//
//		String re3time = StringHelper.replace(re2time,":","分");
//		re3time += "秒";
//
//		re3time = StringHelper.replace(re3time,hour,NumberHelper.getReadCNStringOfNumber(hour));
//		re3time = StringHelper.replace(re3time,minute,NumberHelper.getReadCNStringOfNumber(minute));
//		re3time = StringHelper.replace(re3time,second,NumberHelper.getReadCNStringOfNumber(second));
//
//		return re3+re3time;
//
//	}
	/**
	 * 返回一个日期型字符串的对应的中文描述如1999-09-06 18:30:20 返回:一九九九年九月六号十八点三十分二十秒
	 * @param d 被格式化的日期对象
	 * @return 返回被格式化后的中文字符串,如1999-09-06 18:30:20 返回:一九九九年九月六号十八点三十分二十秒
	 * @throws Exception
	 */
//	public static String formateDateTimeToCNString(String d) throws Exception{
//		if(d==null){
//			throw new NullPointerException();
//		}
//		String re1 = formatDateTimetoString(d,FMT_MMDDYY_CN,Locale.CHINA);
//
//		String year = re1.substring(0,4);
//
//		String day = re1.substring(re1.indexOf("月")+1,re1.indexOf("号"));
//
//		String re2 = StringHelper.replace(re1,year,NumberHelper.getCNStringOfNumber(year));
//		String re3 = StringHelper.replace(re2,day,NumberHelper.getCNStringOfNumber(day));
//		return re3;
//
//	}

    /**
     * 返回指定日期的月份的天数量
     * @param d 日期对象
     */
    public  static int getDaysOfMonth(Date d){
        int year = getYearOfDate(d);
        int month = getMonthOfYear(d);
       return getDaysOfMonth(year, month);
    }
    /**
    * 返回指定日期的月份的天数量
    * @param year 年
    * @param month 月
    */
   public static int getDaysOfMonth(int year, int month){
        int days = 0;
       if(month==2){
           if(((year%4==0)&&(year%100 != 0))||(year%400==0)){
               days = 29;
            }
           else{
               days = 28;
           }
       }
       if((month==4)||(month==6)||(month==9)||(month==11)){
           days = 30;
       }
       if ((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12)){
            days = 31;
       }
      return days;
   }


	/**
	 * 返回系统时间,以日期对象形式返回
	 * 
	 * @return 日期对象
	 */
	public static Date getSystemDate(){
    return new Date(System.currentTimeMillis());
  }

	/**
	 * 返回系统时间,以毫秒形式返回
	 * 
	 * @return 毫秒数
	 */
	public static long getSystemTime(){
		return System.currentTimeMillis();
	}

    /**
     * 获取当前的系统时间,以字符串方式
     *
     * @author 郭皓
     * @date 2017年9月05日 下午5:09:10
     */
    public static String getNowSysTime() {
        return DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd HH:mm:ss.SSS");
    }

	/**
	 * 返回指定时间和系统时间的间隔
	 * 1分钟前
	 * 2分钟前
	 * 1小时
	 * 2小时
	 * 1天
	 * 2天
	 * 1周
	 * 2周
	 * 1月
	 * 2月
	 * 1年
	 * 2年
	 */
	public static String getInfoTimeRelativeSystime(Date InfoTime){
		Double currSeconds = DateTimeHelper.getSecondsOfTwoDate(DateTimeHelper.getSystemDate(), InfoTime);
		if(currSeconds <= 0){
			return "10秒前";
		}else if(currSeconds <= 60){
			return NumberHelper.formatNumber(currSeconds,NumberHelper.NUMBER_IN) + "秒前";
		}else if(currSeconds <= 60 * 60){
			return NumberHelper.formatNumber(currSeconds/60,NumberHelper.NUMBER_IN) + "分钟前";
		}else if(currSeconds <= 3600 * 24){
			return NumberHelper.formatNumber(currSeconds/3600,NumberHelper.NUMBER_IN) + "小时前";
		}else if(currSeconds <= 3600 * 24 * 7){
			return NumberHelper.formatNumber(currSeconds/(3600 * 24),NumberHelper.NUMBER_IN) + "天前";
		}else if(currSeconds <= 3600 * 24 * 28){
			return NumberHelper.formatNumber(currSeconds/(3600 * 24 * 7),NumberHelper.NUMBER_IN) + "周前";
		}else if(currSeconds <= 3600 * 24 * 365){
			return NumberHelper.formatNumber(currSeconds/(3600 * 24 * 30),NumberHelper.NUMBER_IN) + "月前";
		}else if(currSeconds >= 3600 * 24 * 365){
			return NumberHelper.formatNumber(currSeconds/(3600 * 24 * 365),NumberHelper.NUMBER_IN_1) + "年前";
		}
		return currSeconds.toString();
	}
}