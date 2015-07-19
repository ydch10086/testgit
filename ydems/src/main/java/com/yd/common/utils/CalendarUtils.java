package com.yd.common.utils;

import java.util.Calendar;

/**
 * 日历工具类
 * @author Rong.zhu
 *
 */
public class CalendarUtils {
	
	/**
	 * 获取指定日期所在周的周一
	 * @param c
	 * @return
	 */
	public static String getFirstDayOfWeek(Calendar c) {
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//本周周一日期
		return DateUtils.getDate(c.getTime());
	}
	
	/**
	 * 获取指定日期所在周的周日
	 * @param c
	 * @return
	 */
	public static String getLastDayOfWeek(Calendar c) {
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//上周周日日期（老外将周日当做一周第一天）
		c.add(Calendar.WEEK_OF_YEAR, 1);//增加一个星期后是本周周日的日期
		return DateUtils.getDate(c.getTime());
	}
	
	/**
	 * 获取指定日期所在月的第一天
	 * @param c
	 * @return
	 */
	public static String getFirstDayOfMonth(Calendar c) {
		c.set(Calendar.DATE,  1 );
		return DateUtils.getDate(c.getTime());//本月第一天
	}
	
	/**
	 * 获取指定日期所在月的最后一天
	 * @param c
	 * @return
	 */
	public static String getLastDayOfMonth(Calendar c) {
		c.set(Calendar.DATE,  1 );
		c.roll(Calendar.DATE,  - 1 );
		return DateUtils.getDate(c.getTime());//本月最后一天
	}
	
}
