package com.example.android_01_08;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends Activity {

	private TextView textView;

	public static String name;

	public static int age;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		textView = (TextView) this.findViewById(R.id.msg);

		textView.setText(name + age);
	}

}
