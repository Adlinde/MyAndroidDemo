package com.oa.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import com.oa.entity.OaDept;


public class JsonProcessForDate implements JsonValueProcessor {

	 private String format = "yyyy-MM-dd";  
	 
	    public String getFormat() {  
	 
	        return format;  
	    }
	public Object processArrayValue(Object obj, JsonConfig arg1) {
		 System.out.println("@@@"+obj+"#");
		
		 
		return null;
	}

	public Object processObjectValue(String pro, Object obj,
			JsonConfig jc) {

        if (obj instanceof java.util.Date) {  
 
            String str = new SimpleDateFormat(format).format((Date) obj);  
 
            return str;  
 
        }  
 
        return obj.toString();  
 

	}

}
