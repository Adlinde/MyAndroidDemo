package com.oa.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import com.oa.entity.OaDept;
import com.oa.entity.OaUser;


public class JsonProcessForUserUuid implements JsonValueProcessor {

	public Object processArrayValue(Object obj, JsonConfig arg1) {
		 System.out.println("@@@"+obj+"#");
		
		 
		return null;
	}

	public Object processObjectValue(String pro, Object obj,
			JsonConfig jc) {
		 OaUser  user  = (OaUser)obj;
		return user==null?"":user.getUuid();
	}

}
