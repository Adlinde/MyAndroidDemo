package com.example.android_01_07;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends Activity {
	
	private TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.other);
		
		textView=(TextView)this.findViewById(R.id.msg);
		
		Intent intent= getIntent();
		int age=intent.getIntExtra("age", 0);
		String name=intent.getStringExtra("name");
		String sex=intent.getStringExtra("sex");
		
		textView.setText(age+name+sex);
	}

}
