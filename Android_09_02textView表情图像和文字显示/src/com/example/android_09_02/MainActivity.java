package com.example.android_09_02;

import java.lang.reflect.Field;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView textView3;

	public int getResourceId(String name) {

		try {
			//������Դid���Field�Ķ���ʹ�÷��������ʵ��
			Field field = R.drawable.class.getField(name);
			return Integer.parseInt(field.get(null).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView3 = (TextView) this.findViewById(R.id.textview3);
		textView3.setTextColor(Color.RED);
		textView3.setTextSize(20);

		String ht = "ͼ��1��<image src=\"image1\"/>ͼ��2��<image src='ic_launcher'/>ͼ��3��<a href='http://www.hao123.com'><image src='image3'/></a>";
		Log.i("=====>>", "html:" + ht);

		Html.ImageGetter imaGetter = new ImageGetter() {

			@Override
			public Drawable getDrawable(String source) {
				Log.i("=====>>", "source:" + source);
				Drawable drawable = getResources().getDrawable(getResourceId(source));
				drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
				return drawable;
			}

		};
		textView3.setText(Html.fromHtml(ht, imaGetter, null));

		textView3.setMovementMethod(LinkMovementMethod.getInstance());//��ʶ�������ǳ�����
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
