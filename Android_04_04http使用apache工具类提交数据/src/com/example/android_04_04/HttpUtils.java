package com.example.android_04_04;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class HttpUtils {

	public HttpUtils() {
		// TODO Auto-generated constructor stub
	}

	public static String senHttpClirntPost(String path, Map<String, String> map, String encode) {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		
		if(map!=null&&map.isEmpty()){
			
			for (Map.Entry<String,String> entry : map.entrySet()) {
				
				list.add(new BasicNameValuePair(entry.getKey()
						,entry.getValue()));
			}
			
		}
		
		try {
			//ʵ�ֽ�����Ĳ�����װ�����У�
			UrlEncodedFormEntity entity=new UrlEncodedFormEntity(list,encode);
			//ʹ��post��ʽ�ύ����
			HttpPost httpPost=new HttpPost();
			httpPost.setEntity(entity);
			//ִ��post����
			DefaultHttpClient client=new DefaultHttpClient();
			HttpResponse httpResponse=  client.execute(httpPost);
			
			if(httpResponse.getStatusLine().getStatusCode()==200){
				return changeInputstream(httpResponse.getEntity().getContent(),encode);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "";
	}
	
	/**
	 * ��һ��������ת����ָ��������ַ���
	 * @param inputStream
	 * @param encode
	 * @return
	 */
	
	public static String changeInputstream(InputStream inputStream,String encode ) {
		
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		
		byte[] data=new byte[1024];
		
		int len=0;
		
		String result=null;
		
		if(inputStream!=null){
			
			try {
				while ((len=inputStream.read(data))!=-1) {
					outputStream.write(data,0,len);
				}
				result=new String(outputStream.toByteArray(),encode);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		
		String path="";
		
		Map<String,String> params=new HashMap<String, String>();
		
		params.put("username", "admin");
		params.put("password", "123");
		
		String result=HttpUtils.senHttpClirntPost(path, params, "utf-8");
		System.out.println("----->>>>>>"+result);
	}
	
	
}
