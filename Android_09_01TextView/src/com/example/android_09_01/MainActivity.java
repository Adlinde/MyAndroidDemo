package com.example.android_09_01;

import java.lang.reflect.Field;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {


	private TextView textView1,textView2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

				textView1=(TextView)this.findViewById(R.id.textview1);
				textView2=(TextView)this.findViewById(R.id.textview2);
				String html="<font color='red'>Android</font><br>";
				html+="<font><big><i>Android</i></big></font>";
				html+="<big><a href='http://www.baidu.com'>百度</a></big>";
				CharSequence charSequence=Html.fromHtml(html);
				textView1.setText(charSequence);
				textView1.setMovementMethod(LinkMovementMethod.getInstance());
				
				String text="我的URL:http://www.sina.com\n";
				text+="我的电话+0816-56751655";
				textView2.setText(text);
				textView2.setMovementMethod(LinkMovementMethod.getInstance());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
