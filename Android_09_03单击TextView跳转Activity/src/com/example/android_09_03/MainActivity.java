package com.example.android_09_03;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView textView, textView2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) this.findViewById(R.id.textview);
		textView2 = (TextView) this.findViewById(R.id.textview2);
		String text1 = "ÏÔÊ¾Activity1";
		String text2 = "ÏÔÊ¾Activity2";
		//²ð·Ö×Ö·û´®
		SpannableString spannableString = new SpannableString(text1);
		SpannableString spannableString2 = new SpannableString(text2);
		//111
		spannableString.setSpan(new ClickableSpan() {

			@Override
			public void onClick(View widget) {
				Intent intent = new Intent(MainActivity.this, Activity1.class);
				startActivity(intent);

			}
		}, 0, text1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		//2222
		spannableString2.setSpan(new ClickableSpan() {

			@Override
			public void onClick(View widget) {
				Intent intent = new Intent(MainActivity.this, Activity2.class);
				startActivity(intent);

			}
		}, 0, text2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		textView.setText(text1);
		textView2.setText(text2);
		textView.setMovementMethod(LinkMovementMethod.getInstance());
		textView2.setMovementMethod(LinkMovementMethod.getInstance());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
