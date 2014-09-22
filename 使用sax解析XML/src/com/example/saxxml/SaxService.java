package com.example.saxxml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxService {

	public SaxService() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static List<HashMap<String, String>> readXML(InputStream inputStream
			,String nodeName){
		try {
			SAXParserFactory spf=SAXParserFactory.newInstance();
			SAXParser parser=spf.newSAXParser();
			MyHandler handler=new MyHandler(nodeName);
			parser.parse(inputStream, handler);
			return handler.getList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return null;
	}

}
