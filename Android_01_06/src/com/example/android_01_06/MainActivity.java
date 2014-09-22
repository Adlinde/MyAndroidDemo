package com.example.android_01_06;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 从安卓系统中调用剪切板产地数据
//				ClipboardManager clipboardManager=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
//				String name="张三";
//				clipboardManager.setPrimaryClip(ClipData.newPlainText("ss", name));
//				Intent intent=new Intent(MainActivity.this,OtherActivity.class); 
//				startActivity(intent); 
				
				MyDate mydate=new MyDate("jack", 22);
				ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
				String base64String="";
				try {
					ObjectOutputStream objectOutputStream=new ObjectOutputStream(byteArrayOutputStream);
					objectOutputStream.writeObject(mydate);
					base64String=Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT );
					objectOutputStream.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				ClipboardManager clipboardManager=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
				clipboardManager.setPrimaryClip(ClipData.newPlainText("ss", base64String));
				Intent intent=new Intent(MainActivity.this,OtherActivity.class);
				startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
