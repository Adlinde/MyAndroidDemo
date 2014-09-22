package com.oa.util;

import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import com.oa.entity.OaDept;


public class JsonProcessForDatejson implements JsonValueProcessor {

	public Object processArrayValue(Object obj, JsonConfig arg1) {
		 System.out.println("@@@"+obj+"#");
		
		 
		return null;
	}

	public Object processObjectValue(String pro, Object obj,
			JsonConfig jc) {
		 Date  date  = (Date)obj;
		return date==null?"":Factory.getDate("yyyy-MM-dd", date);
	}

}
