package com.example.demo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity {

	private Gallery gallery;
	
	
	private ImageAdapter imageAdapter;
	
	//放15个图片
	public int[] resIds={R.drawable.pand,R.drawable.pand,R.drawable.pand,R.drawable.pand,R.drawable.pand,R.drawable.pand,
			R.drawable.pand,R.drawable.pand,R.drawable.pand
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gallery=(Gallery)this.findViewById(R.id.galley);
		
		imageAdapter=new ImageAdapter(this);
		
		gallery.setAdapter(imageAdapter);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public class ImageAdapter extends BaseAdapter{

		private Context context;
		
		int mGralleyItemBackground;//使用简单的计数器，填充背景图片
		
		public ImageAdapter(Context context) {
			this.context=context;
			
			TypedArray typedArray=obtainStyledAttributes(R.styleable.Gallery);
			
			mGralleyItemBackground=typedArray.getResourceId(R.styleable.Gallery_android_galleryItemBackground, 0);
			
			
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return Integer.MAX_VALUE;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return resIds[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			ImageView imageView=new ImageView(context);
			imageView.setImageResource(resIds[position%resIds.length]);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setLayoutParams(new Gallery.LayoutParams(136,88));
			
			imageView.setBackgroundResource(mGralleyItemBackground);
			
			
			
			return imageView;
		}
		
	}

}
