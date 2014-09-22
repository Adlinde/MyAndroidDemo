package com.example.activit.gson;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.example.activit.entity.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonTools {

	public GsonTools() {
		// TODO Auto-generated constructor stub
	}
	
	public static <T> T getPerson(String jsonString,Class<T> cls){
		T t=null;
		try {
			Gson gson=new Gson();
			t=gson.fromJson(jsonString, cls);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}
	
	/**
	 * 使用Gson进行解析List<person>
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> List<T> getPersons(String jsonString,Class<T> cls){
		List<T> list=new ArrayList<T>();
		try {
			Gson gson=new Gson();
			list=gson.fromJson(jsonString, new TypeToken<List<T>>(){}.getType());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
