package com.oa.util;



import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import com.oa.entity.OaRole;

public class JsonProcessForRole implements JsonValueProcessor {

	public Object processArrayValue(Object obj, JsonConfig arg1) {
		System.out.println("@@@" + obj + "#");
		return null;
	}

	public Object processObjectValue(String pro, Object obj, JsonConfig jc) {
		OaRole role = (OaRole) obj;
		return role == null ? "" : role.getRoleName();

	}

}
