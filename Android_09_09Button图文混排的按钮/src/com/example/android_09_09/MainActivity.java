package com.example.android_09_09;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = (Button) this.findViewById(R.id.button);

		
				SpannableString spannableStringLeft=new SpannableString("left");
				//λͼ
				Bitmap bitmapLeft=BitmapFactory.decodeResource(getResources(), R.drawable.button2);
				//��λͼָ��λ��
				ImageSpan imageSpanLeft=new ImageSpan(bitmapLeft,DynamicDrawableSpan.ALIGN_BOTTOM);
				
				spannableStringLeft.setSpan(imageSpanLeft, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				
				SpannableString spannableStringRight=new SpannableString("left");
				Bitmap bitmapRight=BitmapFactory.decodeResource(getResources(), R.drawable.button1);
				spannableStringRight.setSpan(bitmapRight, 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				
				//����ͼƬ
				button.append(spannableStringLeft);
				button.append("�ҵİ�ť");
				button.append(spannableStringRight);

		Resources res = getResources();
		Drawable leftDrawable = res.getDrawable(R.drawable.button1);
		leftDrawable.setBounds(0, 0, leftDrawable.getIntrinsicWidth(), leftDrawable.getIntrinsicHeight());

		Drawable rightDrawable = res.getDrawable(R.drawable.button2);
		rightDrawable.setBounds(0, 0, rightDrawable.getIntrinsicWidth(), rightDrawable.getIntrinsicHeight());

		button.setCompoundDrawables(leftDrawable, null, rightDrawable, null);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
