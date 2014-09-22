package com.example.android_09_05;

import java.lang.reflect.Field;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText editText;
	private Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText=(EditText)this.findViewById(R.id.edittext);
		button=(Button)this.findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int randomId=1+new Random().nextInt(3);
				try {
					Field field=R.drawable.class.getDeclaredField("face"+randomId);
					int resourceId=Integer.parseInt(field.get(null).toString());
					//在安卓中药显示图片信息，必须使用Bitmao位图的对象来装载
					Bitmap bitmap=BitmapFactory.decodeResource(getResources(), resourceId);				
					ImageSpan imageSpan=new ImageSpan(MainActivity.this,bitmap);
					SpannableString spannableString=new SpannableString("face");
					spannableString.setSpan(imageSpan, 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
					editText.append(spannableString);
				} catch (Exception e) {
					
				}
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
