package com.example.android_demo_77le;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {
	
	public static String convertDate(Date date){
		
		String datestring=null;
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd��");
		
		datestring=sdf.format(date);
		
		return datestring;
	}

}
