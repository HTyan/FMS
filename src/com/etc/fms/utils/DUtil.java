package com.etc.fms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DUtil {

	/**
	 * @param args
	 */

	public static String parseDateToString(Date d) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(d);
	}

	public static Date parseStringToDate(String time) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.parse(time);
	}

	public static long getTime(String time) throws ParseException {
		long l = 0l;
		if (time == null) {
			l = new Date().getTime();
		} else {
			l = parseStringToDate(time).getTime();
		}
		return l;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DUtil.parseDateToString(new Date()));
	}

}
