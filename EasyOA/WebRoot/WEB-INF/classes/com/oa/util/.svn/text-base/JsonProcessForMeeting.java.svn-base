package com.oa.util;



import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import com.oa.entity.OaMeeting;
import com.oa.entity.OaRole;

public class JsonProcessForMeeting implements JsonValueProcessor {

	public Object processArrayValue(Object obj, JsonConfig arg1) {
		System.out.println("@@@" + obj + "#");
		return null;
	}

	public Object processObjectValue(String pro, Object obj, JsonConfig jc) {
		OaMeeting meeting = (OaMeeting) obj;
		return meeting == null ? "" : meeting.getMeetingName();

	}

}
