package com.example.android_09_08;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener, OnTouchListener, OnFocusChangeListener, OnKeyListener {

	private int value = 1;

	private Button commonButton;
	private Button imageButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		commonButton = (Button) this.findViewById(R.id.commonbutton);
		imageButton = (Button) this.findViewById(R.id.imagebutton);
		commonButton.setOnClickListener(this);
		imageButton.setOnClickListener(this);
		imageButton.setOnTouchListener(this);
		imageButton.setOnFocusChangeListener(this);
		imageButton.setOnKeyListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (KeyEvent.ACTION_DOWN == event.getAction()) {
			v.setBackgroundResource(R.drawable.button1);
		} else if (KeyEvent.ACTION_UP == event.getAction()) {
			v.setBackgroundResource(R.drawable.button2);
		}
		return false;
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		// TODO Auto-generated method stub
		if (hasFocus) {
			v.setBackgroundResource(R.drawable.button2);
		} else {
			v.setBackgroundResource(R.drawable.button1);
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == KeyEvent.ACTION_UP) {
			v.setBackgroundResource(R.drawable.button1);
		} else if (event.getAction() == KeyEvent.ACTION_DOWN) {
			v.setBackgroundResource(R.drawable.button2);
		}
		return false;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Button button = (Button) v;
		if (value == 1 && button.getWidth() == getWindowManager().getDefaultDisplay().getWidth()) {
			value = -1;
		} else if (value == -1 && button.getWidth() < 100) {
			value = 1;
		}
		button.setWidth(button.getWidth() + (int) (button.getWidth() * 0.1) * value);
		button.setHeight(button.getHeight() + (int) (button.getHeight() * 0.1) * value);
	}

}
