package com.example.android_01_06;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Button;
import android.widget.TextView;

public class OtherActivity extends Activity {
	
	private TextView textView;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		
		textView=(TextView)findViewById(R.id.msg);
		
		ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
		
		ClipData cd=clipboardManager.getPrimaryClip(); 
		
		String ms=cd.getItemAt(0).getText().toString(); 
		
		byte[] base64_byte=Base64.decode(ms, Base64.DEFAULT);
		
		ByteArrayInputStream ByteArrayInputStream=new ByteArrayInputStream(base64_byte);
		
		try {
			ObjectInputStream ObjectInputStream=new ObjectInputStream(ByteArrayInputStream);
			MyDate mydate=(MyDate)ObjectInputStream.readObject();
			textView.setText(mydate.toString());	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
