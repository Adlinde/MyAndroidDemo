package com.example.demo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity implements OnClickListener{

	private ProgressBar progressBar;
	
	private Button button1,button2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_PROGRESS);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		
		setContentView(R.layout.activity_main);
		//如何设置窗口有刻度的效果
		button1=(Button)this.findViewById(R.id.button1);
		button2=(Button)this.findViewById(R.id.button2);
		progressBar =(ProgressBar)this.findViewById(R.id.progressbar5);
		
		
		setProgressBarVisibility(true);
		setProgressBarIndeterminate(true);
		setProgress(3500);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			progressBar.setProgress((int)
					(progressBar.getProgress()*1.2));
			
			progressBar.setSecondaryProgress((int)
					(progressBar.getSecondaryProgress()*1.2));
			
			
			break;
        case R.id.button2:
        	progressBar.setProgress((int)
					(progressBar.getProgress()*0.8));
			
			progressBar.setSecondaryProgress((int)
					(progressBar.getSecondaryProgress()*0.8));
			break;
		default:
			break;
		}
		
	}

}
