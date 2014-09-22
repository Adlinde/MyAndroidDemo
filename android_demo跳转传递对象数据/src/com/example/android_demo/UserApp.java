package com.example.android_demo;

import android.app.Application;

public class UserApp extends Application {
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		setUsername("уехЩ");
	}

}
