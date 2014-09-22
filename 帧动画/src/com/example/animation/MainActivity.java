package com.example.animation;

import android.os.Bundle;
import android.os.MessageQueue;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView textView=(TextView)this.findViewById(R.id.textview);
		textView.setBackgroundResource(R.drawable.frame);
		final AnimationDrawable drawable=(AnimationDrawable) textView.getBackground();
		
		getMainLooper().myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
			
			@Override
			public boolean queueIdle() {
				drawable.start();//Æô¶¯¶¯»­
				return false;
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
