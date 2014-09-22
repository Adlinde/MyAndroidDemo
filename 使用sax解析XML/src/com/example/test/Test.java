package com.example.test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import com.example.Http.HttpUtils;
import com.example.saxxml.SaxService;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String[] args) {
		
		String path="http://localhost:8080/myhttp/person.xml";
		
		InputStream inputStream=HttpUtils.getXML(path);
		
		try {
			List<HashMap<String, String>> list=SaxService
					.readXML(inputStream, "person");
			for(HashMap<String, String> map:list){
				
				System.out.println(map.toString());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	

}
