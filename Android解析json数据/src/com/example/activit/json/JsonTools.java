package com.example.activit.json;

import org.json.JSONObject;

import com.example.activit.entity.Person;

public class JsonTools {

	public JsonTools() {
		// TODO Auto-generated constructor stub
	}
	
	public static Person getPerson(String key,String jsonString){
		Person person=new Person();
		
		try {
			JSONObject jsonObject=new JSONObject(jsonString);
			JSONObject persObject=jsonObject.getJSONObject("person");
			
			person.setId(persObject.getInt("id"));
			person.setName(persObject.getString("name"));
			person.setAdrees(persObject.getString("address"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return person;
	}

}
