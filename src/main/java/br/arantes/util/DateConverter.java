package br.arantes.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateConverter {
	/**
	 * Transforma um Calendar com a data informada
	 * 
	 * @param string com o formato dd/MM/yyyy HH:mm
	 * @return
	 */
	public static Calendar stringTimeBrToCalendar(String string) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date;
		try {
			date = sdf.parse(string);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			return cal;
		} catch (ParseException e) {
			return null;
		}

	}

	/**
	 * Transforma um Calendar com a data informada
	 * 
	 * @param string com o formato dd/MM/yyyy
	 * @return
	 */
	public static Calendar stringBrToCalendar(String string) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = sdf.parse(string);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			return cal;
		} catch (ParseException e) {
			return null;
		}

	}

	/**
	 * Transforma uma string com o formato yyyy-MM-dd HH:mm do Calendar informado
	 * 
	 * @param calendar
	 * @return
	 */
	public static String calendarToStringTime(Calendar calendar) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			return sdf.format(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Transforma um Calendar com a data informada
	 * 
	 * @param string com o formato yyyy-MM-dd HH:mm
	 * @return
	 */
	public static Calendar stringTimeToCalendar(String string) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date;
		try {
			date = sdf.parse(string);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			return cal;
		} catch (ParseException e) {
			return null;
		}

	}

	/**
	 * Transforma uma string com o formato dd/MM/yyyy do Calendar informado
	 * 
	 * @param calendar
	 * @return
	 */
	public static String calendarToStringBr(Calendar calendar) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sdf.format(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Transforma uma string com o formato passado por parametro do Calendar
	 * informado
	 * 
	 * @param calendar
	 * @param formato
	 * @return
	 */
	public static String calendarToString(Calendar calendar, String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		try {
			return sdf.format(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	/**
	 * Transforma uma string com o formato passado por parametro do Date
	 * informado
	 * 
	 * @param date
	 * @param formato
	 * @return
	 */
	public static String dateToString(Date date, String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		try {
			return sdf.format(date.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	/**
	 * Transforma o Calendar em um XMLGregorianCalendar
	 * 
	 * @param Calendar
	 * @return XMLGregorianCalendar
	 */
	public static XMLGregorianCalendar calendarToXMLGregorianCalendar(Calendar calendar) {
		try {
			Date cDate = calendar.getTime();
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(cDate);
			return DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR),
					cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Transforma um Date em String com formato aceito no SAP
	 * 
	 * @param data
	 * @return
	 */
	public static String formatToSAP(final Date data) {
		return new SimpleDateFormat("yyyy/MM/dd").format(data).replaceAll("/", "");
	}

	/**
	 * Transforma um Calendar com a data informada
	 * 
	 * @param string com o formato yyyyMMdd (enviado pelo SAP)
	 * @return
	 */
	public static Calendar obterDataFormatoSAP(String string) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date;
		try {
			date = sdf.parse(string);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			return cal;
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * Transforma um java.util.date em um Calendar
	 * 
	 * @param date
	 * @return
	 */
	public static Calendar dateToCalendar(Date date) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
