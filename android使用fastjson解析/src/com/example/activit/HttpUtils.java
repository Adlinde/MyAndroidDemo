package com.example.activit;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

	public HttpUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getXML(String path){
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
					
					return changeInputStream(connection.getInputStream());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "";
	}

	private static String changeInputStream(InputStream inputStream) {
		String jsonString="";
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		int len=0;
		byte[] data=new byte[1024];
		
		try {
			while((len=inputStream.read(data))!=-1){
				
				outputStream.write(data,0,len);
				
			}
			jsonString=new String(outputStream.toByteArray());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return jsonString;
	}


}
