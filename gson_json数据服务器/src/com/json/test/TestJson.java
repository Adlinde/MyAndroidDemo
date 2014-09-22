package com.json.test;

import org.json.JSONException;
import com.json.entity.Person;
import com.json.service.JsonService;
import com.json.tools.JsonTools;

public class TestJson {
	
	public static void main(String[] args) throws JSONException {
		String msg="";
		JsonService service=new JsonService();
//		Person person=service.getPerson();
//		msg= JsonTools.createJsonString("Person", person);
//		System.out.println(msg);
		
		
		msg= JsonTools.createJsonString( service.getPersonList());
		
		System.out.println(msg);
	}

}
