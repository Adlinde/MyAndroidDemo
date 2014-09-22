package com.example.demo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView imageView=(ImageView)this.findViewById(R.id.imageview);
		//设置第一个图片
		//表示宽度200高度100
		imageView.setLayoutParams(new LinearLayout.LayoutParams(200,100));
		setTitle("heght:"+imageView.getLayoutParams().height+"width"+imageView.getLayoutParams().width);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
