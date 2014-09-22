package com.json.tools;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

public class JsonTools {

	public JsonTools() {
		// TODO Auto-generated constructor stub
	}
	
	public static String createJsonString(Object value) throws JSONException{
		Gson gson=new Gson();
		
		return gson.toJson(value);
		
	}

}
