package com.fladioarmandika.tridaya.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class ModelAttributeGenerator {
	
	public static int generateId() {
		Random rand = new Random();
		return rand.nextInt(99999999) + 20192939; 
	}
	
	public static String getStringDate(Date date) throws ParseException {
		DateFormat df2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
		
		SimpleDateFormat formatnow = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH); 
		SimpleDateFormat formatneeded=new SimpleDateFormat("YYYY-MM-dd");  
		Date date1 = formatnow.parse(df2.format(date));
		return formatneeded.format(date1);
	}

}
