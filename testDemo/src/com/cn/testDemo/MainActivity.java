package com.cn.testDemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity {

	private RoundProgressBar roundPb;//环形进度
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		roundPb = (RoundProgressBar)this.findViewById(R.id.round);
		double schemeProgress = Double.valueOf("20");
		roundPb.setProgress(schemeProgress);//设置环形进度条
	}
}
