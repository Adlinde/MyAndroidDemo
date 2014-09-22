package com.example.android_demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends Activity {

	
	private UserApp user;
	
	private TextView textview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);	
		textview=(TextView) this.findViewById(R.id.msg);
		user=(UserApp) getApplication();
		textview.setText(user.getUsername());
	}
}
