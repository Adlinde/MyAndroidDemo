package com.example.demo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class MainActivity extends Activity implements OnRatingBarChangeListener {

	private RatingBar ratingBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ratingBar=(RatingBar)this.findViewById(R.id.ratingbar);
		
		ratingBar.setMax(100);
		
		ratingBar.setProgress(20);//���õ�ǰ�Ŀ̶�
		
		
		ratingBar.setOnRatingBarChangeListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
		
		
		int progress=ratingBar.getProgress();
		
		Toast.makeText(MainActivity.this, "progress"+rating, 1).show();
		
	}

}
