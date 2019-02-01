package com.armadillo.api.util;


import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletContext;




/**
 */
public class Util {
	
	public static void servletLog(
			ServletContext ctx,
			String classname,
			String methodname,
			String msg
	) {
		ctx.log(classname+": "+methodname+": "+msg);							
	}
	
	
    /**
     * The valid input character list
     */
    public static final String VALID_INPUT_CHARS = "-*><";
    
    
    
	private static final SimpleDateFormat DATE_FORMAT =
		new SimpleDateFormat("yyyy-MM-dd");
	
	private static final SimpleDateFormat DATE_FORMAT_DMY =
		new SimpleDateFormat("dd-MM-yyyy");
	
	private static final SimpleDateFormat DATE_TIME_FORMAT =
		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static final SimpleDateFormat DATE_TEXT_FORMAT =
		new SimpleDateFormat("EEE, d MMM yyyy");
	
	private static final SimpleDateFormat DATE_TEXT_FORMAT2 =
		new SimpleDateFormat("d-MMM-yyyy");
	
	private static final SimpleDateFormat DATE_TEXT_FORMAT3 =
		new SimpleDateFormat("MMMMMMMMMMM yyyy");
	
	private static final SimpleDateFormat DATE_TEXT_FORMAT4 =
		new SimpleDateFormat("d-MMM");
	
	private static final SimpleDateFormat DATE_TEXT_FORMAT5 =
		new SimpleDateFormat("d");
		
	private static final SimpleDateFormat DATE_TEXT_FORMAT6 =
		new SimpleDateFormat("yyyyMMdd");
	
	private static final SimpleDateFormat DATE_TEXT_FORMAT7 =
		new SimpleDateFormat("d-MMM-yy");

	private static final SimpleDateFormat DATE_TEXT_FORMAT8 =
		new SimpleDateFormat("MM/dd/yy");	
	
	
	public static Date dateDaysAdd(Date date, int days) {
		// init calendar object
		Calendar calendar = Calendar.getInstance();
		// set calendar to start of month
		calendar.setTime(date);
		// add days from date to get last day of month
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}
	
	public static Date dateDaysAdd(String date, String days) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		try {
			cal.setTime( DATE_FORMAT.parse(date) );
			if (days != null) cal.add( Calendar.DATE, Integer.parseInt(days) ); 
		}
		catch (ParseException pe) {}	
		return cal.getTime();
	}
	
	
	public static Date convertDateStringToDate(String dateStr) {
		try {
			return DATE_FORMAT.parse(dateStr);
		} catch (ParseException pe) {
			return null;
		}
	}
	
	public static String convertDateToDateString(Date date) {
		return DATE_FORMAT.format(date);
	}			
	
	
	public static boolean invalidChars(String str) {
		if (str == null) return false;
		int stringSize = str.length();		 
		for (int i = 0; i < stringSize; i++) {
			if(	!(
					Character.isLetter(str.charAt(i)) || 
					Character.isDigit(str.charAt(i)) ||
					VALID_INPUT_CHARS.indexOf(str.charAt(i)) > -1
			) 
			) return true;
		}
		return false;
	}
	
	
	
	/**
	 * Formats a date using the default JDBC format
	 */
	public static String dateFormat(Date d)
	{
		return d == null ? "" : DATE_FORMAT.format(d);
	}
	public static String dateFormatDmy(Date d)
	{
		return d == null ? "" : DATE_FORMAT_DMY.format(d);
	}
	
	/**
	 * Formats a timestamp using the default JDBC format
	 */
	public static String dateTimeFormat(Date d)
	{
		return d == null ? "" : DATE_TIME_FORMAT.format(d);
	}
	
	/**
	 * Formats a date -> text format
	 */
	public static String dateTextFormat(Date d)
	{
		return d == null ? "" : DATE_TEXT_FORMAT.format(d);
	}
	
	
	/**
	 * Formats a date -> text format
	 */
	public static String dateTextFormat2(Date d)
	{
		return d == null ? "" : DATE_TEXT_FORMAT2.format(d);
	}
	
	/**
	 * Formats a date -> text format
	 */
	public static String dateTextFormat3(Date d)
	{
		return d == null ? "" : DATE_TEXT_FORMAT3.format(d);
	}    
	
	/**
	 * Formats a date -> text format
	 */
	public static String dateTextFormat4(Date d)
	{
		return d == null ? "" : DATE_TEXT_FORMAT4.format(d);
	} 
	
	/**
	 * Formats a date -> text format
	 */
	public static String dateTextFormat5(Date d)
	{
		return d == null ? "" : DATE_TEXT_FORMAT5.format(d);
	}

	
	/**
	 * Formats a date -> text format
	 */
	public static String dateTextFormat6(Date d)
	{
		return d == null ? "" : DATE_TEXT_FORMAT6.format(d);
	}
	
	public static String dateTextFormat7(Date d)
	{
		return d == null ? "" : DATE_TEXT_FORMAT7.format(d);
	}
	
	public static String dateTextFormat8(Date d)
	{
		return d == null ? "" : DATE_TEXT_FORMAT8.format(d);
	}
	
	
	
	public static String dateTextFormat2(int year, int month, int day) {  	
		if (year <= 1) return ""; 
		
		Calendar cal = Calendar.getInstance();
		cal.set(
				year,
				month-1,
				day
		);
		java.util.Date d = cal.getTime();
		
		return d == null ? "" : DATE_TEXT_FORMAT2.format(d);
	}
	
	
	
	/**
	 * Converts a java.util.Date to a java.sql.Timestamp
	 */
	public static Timestamp toTimestamp(Date d)
	{
		return (d == null)
		? null
				: new Timestamp(d.getTime());
	}
	
	
	public static long dateDifference(Date d1, Date d2)
	{
		int DAY = 86400000;
		
		long millis = d2.getTime() - d1.getTime();
		return  millis/DAY;
	}
	
   
	public static Long[] calendarDifference(Calendar calendar1, Calendar calendar2)
	{
	    long milliseconds1 = calendar1.getTimeInMillis();
	    long milliseconds2 = calendar2.getTimeInMillis();
	    long diff = milliseconds2 - milliseconds1;
	    long diffSeconds = diff / 1000;
	    long diffMinutes = diff / (60 * 1000);
	    long diffHours = diff / (60 * 60 * 1000);
	    long diffDays = diff / (24 * 60 * 60 * 1000);

	    Long[] difference = new Long[4];// long array with 4 elements
	    difference[0]=diffDays;
	    difference[1]=diffHours;
	    difference[2]=diffMinutes;
	    difference[3]=diffSeconds;
		return difference;
	}

	
	
	public static java.util.Date toDay = new java.util.Date();
	public static java.util.Calendar calendar = java.util.Calendar.getInstance();
	public static int iYear = calendar.get(java.util.Calendar.YEAR);
	public static int iMonth = (calendar.get(java.util.Calendar.MONTH)+1);
	public static int iDay = calendar.get(java.util.Calendar.DAY_OF_MONTH);
	public static int iHour = calendar.get(java.util.Calendar.HOUR_OF_DAY);
	public static int iMinute = calendar.get(java.util.Calendar.MINUTE);
	public static int iSecond = calendar.get(java.util.Calendar.SECOND);
	

	
	public static String toTime(Calendar c) {	    		    	
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumIntegerDigits(2);
		try {
			return 
			nf.format(c.get(Calendar.HOUR_OF_DAY))+":"+
			nf.format(c.get(Calendar.MINUTE))+":"+
			nf.format(c.get(Calendar.SECOND));
		} catch (Exception e) {
			return "00:00:00";
		}	    		    	
	}
	
	public static String toTimeHHMM(Calendar c) {	    		    	
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumIntegerDigits(2);
		try {
			return 
			nf.format(c.get(Calendar.HOUR_OF_DAY))+":"+
			nf.format(c.get(Calendar.MINUTE));
		} catch (Exception e) {
			return "00:00";
		}	    		    	
	}
	
	
	public static Long dateTimeToMillis(Date date, String time) throws Exception {	
		String dateString = dateFormat(date)+" "+time;
		Date dateParse = DATE_TIME_FORMAT.parse(dateString);
		return dateParse.getTime();
	}
	
	
	/**
	 * Encloses a string in quotation marks
	 * if it contains a comma.
	 * @param s the string
	 */
	public static String quote(String s)
	{
		if (s != null) {
			if (s.indexOf(",") > -1) {
				StringBuffer sb = new StringBuffer();
				sb.append('"');
				sb.append(s);
				sb.append('"');
				s = sb.toString();
			}
		}
		return s;
	}
	
	

	
}
