package com.example.android_01_09;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OtherActivity extends Activity {
	
	private Button button;
	
	private TextView textView;
	
	private EditText editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		
		button=(Button) this.findViewById(R.id.button2);
		
		textView=(TextView) this.findViewById(R.id.msg);
		
		editText=(EditText) this.findViewById(R.id.three);
		
		Intent intent=getIntent();
		
		int a=intent.getIntExtra("a", 0);
		int b=intent.getIntExtra("b", 0);
		textView.setText(a+"+"+b+"="+"?");
		
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				int three=Integer.parseInt(editText.getText().toString());
				intent.putExtra("three", three);
				//通过Intent对象返回结果，setResult方法，
				setResult(2,intent);
				//setResult(resultCode, data)  resultCode和MainActivity类中onActivityResult方法中int resultCode值相同
				finish();//结束当前的Activity的生命周期
			}
		});
	}

}
