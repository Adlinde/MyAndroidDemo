package com.example.demo;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
	
	private TabHost tabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		tabHost=getTabHost();
		
		tabHost.addTab(tabHost.newTabSpec("系统菜单")
				.setIndicator("tabl", getResources().getDrawable(R.drawable.button1)));
		
		tabHost.addTab(tabHost.newTabSpec("系统菜单2")
				.setIndicator("tab2", getResources().getDrawable(R.drawable.button2)));
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
