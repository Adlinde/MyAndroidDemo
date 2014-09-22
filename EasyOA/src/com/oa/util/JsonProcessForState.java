package com.oa.util;

import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import com.oa.entity.OaDept;


public class JsonProcessForState implements JsonValueProcessor {

	public Object processArrayValue(Object obj, JsonConfig arg1) {
		 System.out.println("@@@"+obj+"#");
		
		 
		return null;
	}

	public Object processObjectValue(String pro, Object obj,
			JsonConfig jc) {
		 Integer  state  = Integer.valueOf((String) obj);
		return state==0?"Ò»°ã":"½ô¼±";
	}

}
