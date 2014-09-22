package com.pull.test;

import java.io.InputStream;
import java.util.List;

import com.pull.entity.Person;
import com.pull.http.HttpUtils;
import com.pull.parser.PullXMLTools;

public class Text {

	public Text() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		String path="";
		InputStream inputStream=HttpUtils.getXML(path);
		List<Person> list=null;
		try {
			list=PullXMLTools.parserXML(inputStream, "utf-8");
			for (Person person : list) {
				System.out.println(person.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
