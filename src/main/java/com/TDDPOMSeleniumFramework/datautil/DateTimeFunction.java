package com.TDDPOMSeleniumFramework.datautil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTimeFunction {

	/**
	 * <b>FUNCTION NAME:</b> getCurrentDateTime <br>
	 * <b>DESCRIPTION:</b> This function/method is use to get the current system
	 * date or time based on the paramater indicated <br>
	 * <b>DATE CREATED:</b> 03/08/2017 <br>
	 * <br>
	 * {@link} <a href=
	 * "http://javatechniques.com/blog/dateformat-and-simpledateformat-examples/">Parsing
	 * a variety of date strings</a>
	 * 
	 * @param paramStrDayFormat
	 *            string format for day/time
	 * @return current day in string format
	 * @author Mark.Salas
	 */

	public static String getCurrentDateTime(String paramStrDayFormat) {

		Calendar calobj = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(paramStrDayFormat);
		return df.format(calobj.getTime());

	}

	public static String convert24HrTo12HrTime(String paramStrTime) {

		String _12HourDt = null;
		SimpleDateFormat _24HourSDF = null;
		SimpleDateFormat _12HourSDF = null;
		Date _24HourDt = null;
		try {
			_24HourSDF = new SimpleDateFormat("HH:mm");
			_12HourSDF = new SimpleDateFormat("hh:mm");
			_24HourDt = _24HourSDF.parse(paramStrTime);
			_12HourDt = _12HourSDF.format(_24HourDt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return _12HourDt;
	}

	public static String convertDateFormatToAnother(final String paramStrDate, final String paramStrDateFormatToConvert,
			final String paramStrDateFormatConverted) {

		String strNewDateFormat = "";
		try {
			DateFormat varSrcDf = new SimpleDateFormat(paramStrDateFormatToConvert);
			// Parse the date string into Date object
			Date date = varSrcDf.parse(paramStrDate);

			DateFormat varDestDf = new SimpleDateFormat(paramStrDateFormatConverted);
			strNewDateFormat = varDestDf.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return strNewDateFormat;
	}

	/**
	 * <h1>FUNCTION NAME:</h1> getPreviousYear()<br>
	 * <h1>DESCRIPTION:</h1> Return the previous year. Previous year = current
	 * year - 1;
	 * 
	 * @return integer calendar year format
	 */
	public static int getPreviousYear() {
		Calendar prevYear = Calendar.getInstance();
		prevYear.add(Calendar.YEAR, -1);
		return prevYear.get(Calendar.YEAR);
	}

	/**
	 * <h1>FUNCTION NAME:</h1> getCurrentYear()<br>
	 * <h1>DESCRIPTION:</h1> Return the current year.
	 * 
	 * @return integer calendar year format
	 */
	public static int getCurrentYear() {
		Calendar prevYear = Calendar.getInstance();
		return prevYear.get(Calendar.YEAR);
	}

	/**
	 * <h1>FUNCTION NAME:</h1> getCurrentDate()<br>
	 * <h1>DESCRIPTION:</h1> Return the current date of specified date format.
	 * 
	 * @return String date format
	 */
	public static String getCurrentDate(String paramStrDateFormat) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(paramStrDateFormat);
		LocalDate localDate = LocalDate.now();
		return dtf.format(localDate);

	}
	
	public static String getMondayOfTheWeek(String paramStrDateFormat){
		
		DateFormat dtf = new SimpleDateFormat(paramStrDateFormat);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return dtf.format(c.getTime());
	}

}
