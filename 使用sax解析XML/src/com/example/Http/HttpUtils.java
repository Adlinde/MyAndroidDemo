package com.example.Http;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

	public HttpUtils() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static InputStream getXML(String path){
		InputStream inputStream=null;
		try {
			URL url=new URL(path);
			if(url!=null){
				
				HttpURLConnection connection=(HttpURLConnection)url
						.openConnection();
				connection.setConnectTimeout(3000);
				connection.setDoInput(true);
				connection.setRequestMethod("GET");
				
				int code=connection.getResponseCode();
				if(code==200){
					
					inputStream=connection.getInputStream();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return inputStream;
	}

}
