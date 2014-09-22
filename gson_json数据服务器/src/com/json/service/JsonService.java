package com.json.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.json.entity.Person;

public class JsonService {

	public JsonService() {
		// TODO Auto-generated constructor stub
	}
	
	public Person getPerson(){
		Person person=new Person(1001,"jack","beijing");
		return person;
	}
	
	public List<Person> getPersonList(){
		
		List<Person> list=new ArrayList<Person>();
		Person person=new Person(1001,"jack","beijing");
		Person person2=new Person(1002,"jack2","beijing2");
		Person person3=new Person(1003,"jack3","beijing3");
		list.add(person);
		list.add(person2);
		list.add(person3);
		return list;
	}
	
	public List<String> getListString(){
		
		List<String> list=new ArrayList<String>();
		
		list.add("1");
		list.add("2");
		list.add("3");
		return list;
	}
	
	public List<Map<String, Object>> getListMaps(){
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		
		Map<String, Object> map1=new HashMap<String, Object>();
		map1.put("id", 1001);
		map1.put("name", "jack");
		map1.put("address", "beijing");
		
		Map<String, Object> map2=new HashMap<String, Object>();
		map2.put("id", 1002);
		map2.put("name", "jack2");
		map2.put("address", "beijing2");
		
		list.add(map1);
		list.add(map2);
		return list;
	}
	

}
