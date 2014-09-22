package com.json.service;

import org.json.JSONException;

public class TestJson {
	
	public static void main(String[] args) throws JSONException {
		String msg="";
		JsonService service=new JsonService();
//		Person person=service.getPerson();
//		msg= JsonTools.createJsonString("Person", person);
//		System.out.println(msg);
		
		
		msg= JsonTools.createJsonString("Persons", service.getPersonList());
		
		System.out.println(msg);
	}

}
