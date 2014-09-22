package com.oa.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import com.oa.entity.OaDept;


public class JsonProcessForDept implements JsonValueProcessor {

	public Object processArrayValue(Object obj, JsonConfig arg1) {
		return null;
	}

	public Object processObjectValue(String pro, Object obj,
			JsonConfig jc) {
		OaDept  dept  = (OaDept)obj;
		String json=dept.getUuid()+"";	
		return json==null?"":json;
	}

}
