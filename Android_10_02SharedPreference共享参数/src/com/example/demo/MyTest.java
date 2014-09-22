package com.example.demo;

import java.util.Map;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;

public class MyTest extends AndroidTestCase {

	private String TAG="MyTest";
	
	public MyTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void save(){
		Context context=getContext();
		MySharedPreference mySharedPreference=new MySharedPreference(context);
		
		boolean flag=mySharedPreference.saveMessage("admin", "123");
		
		Log.i(TAG, "---->"+flag);
	}

	public void find(){
		Context context=getContext();
		MySharedPreference mySharedPreference=new MySharedPreference(context);
		
		Map<String, Object> map=mySharedPreference.getMessage();
		
		Log.i(TAG, "---->"+map.toString());
	}
	
	
}
