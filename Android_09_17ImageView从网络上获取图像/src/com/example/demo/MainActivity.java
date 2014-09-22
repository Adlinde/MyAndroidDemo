package com.example.demo;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	
	private ImageView imageView;
	
	private Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageView=(ImageView)this.findViewById(R.id.imageview);
		
		button=(Button)this.findViewById(R.id.button);
		
		
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//从网络中获取图片
				try {
					InputStream inputStream=HttpUtils
							.getimageViewInputStream();
					
					Bitmap bitmap=BitmapFactory
							.decodeStream(inputStream);
					imageView.setImageBitmap(bitmap);
					
					
					
				} catch (IOException e) {
					// TODO: handle exception
				}
				
				
				
				//
//				byte[] data=HttpUtils.getImageViewArray();
//				Bitmap bitmap=BitmapFactory.decodeByteArray(data, 0, data.length);
//				imageView.setImageBitmap(bitmap);
				
				
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
