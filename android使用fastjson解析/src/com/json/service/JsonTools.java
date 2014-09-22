package com.json.service;


import org.json.JSONException;
import org.json.JSONObject;

public class JsonTools {

	public JsonTools() {
		// TODO Auto-generated constructor stub
	}
	
	public static String createJsonString(String key,Object value) throws JSONException{
		JSONObject jsonObject=new JSONObject();;
		jsonObject.put(key, value);
		return jsonObject.toString();
		
	}

}
