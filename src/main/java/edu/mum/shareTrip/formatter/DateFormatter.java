package edu.mum.shareTrip.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter<Date> {

	private SimpleDateFormat dateFormat;
	private String datePattern = "MM-dd-yyyy";
	
	public DateFormatter(){
		dateFormat = new SimpleDateFormat(datePattern);
	}
	
	@Override
	public String print(Date object, Locale locale) {
		return dateFormat.format(object);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		return dateFormat.parse(text);
	}

}
