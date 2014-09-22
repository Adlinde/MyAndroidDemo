package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import android.content.Context;
import android.content.SharedPreferences;


public class MySharedPreference {

	private Context context;
	public MySharedPreference(Context context) {
		// TODO Auto-generated constructor stub
		this.context=context;
	}
	
	//共享参数，存储小的，少量的数据
	public Map<String, Object> getMessage(){
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		SharedPreferences sharedPreferences=context.getSharedPreferences(
				"userinfo", Context.MODE_PRIVATE);
		String name=sharedPreferences.getString("name", "");
		String pswd=sharedPreferences.getString("pswd", "");
		
		map.put("name", name);
		map.put("pswd", pswd);
		return map;
	}
	
	
	public boolean saveMessage(String name,String pswd){
		boolean flag=false;
		
		SharedPreferences sharedPreferences=context.getSharedPreferences(
				"userinfo", Context.MODE_PRIVATE);
		
		SharedPreferences.Editor editor=sharedPreferences.edit();
		editor.putString("name", name);
		editor.putString("pswd", pswd);
		flag=editor.commit();//将数据持久化到存储介质中
		return flag;
	}

	

}
