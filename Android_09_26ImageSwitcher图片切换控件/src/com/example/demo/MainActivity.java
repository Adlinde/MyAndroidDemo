package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity implements OnClickListener,ViewFactory{
	
	
	private ImageSwitcher imageSwitcher;
	
	private Button button1,button2;
	
	private int index=0;//浏览图片的次序
	
	private List<Drawable> list=new ArrayList<Drawable>();//存放用户的图片信息；

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageSwitcher=(ImageSwitcher)this.findViewById(R.id.imageswitcher1);
		
		button1=(Button)this.findViewById(R.id.button1);
		button2=(Button)this.findViewById(R.id.button2);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		
		imageSwitcher.setFactory(this);
		
		//往list集合中装载图片信息
		//系统调用getDrawable（id）
		list.add(getResources().getDrawable(R.drawable.pand));
		list.add(getResources().getDrawable(R.drawable.pand));
		list.add(getResources().getDrawable(R.drawable.pand));
		list.add(getResources().getDrawable(R.drawable.pand));
		list.add(getResources().getDrawable(R.drawable.pand));
		list.add(getResources().getDrawable(R.drawable.pand));
		list.add(getResources().getDrawable(R.drawable.pand));
		list.add(getResources().getDrawable(R.drawable.pand));
		//初始化加载图片的信息
		if(list.size()>0){
			
			imageSwitcher.setImageDrawable(list.get(0));
		}
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public View makeView() {

		return new ImageView(MainActivity.this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			index--;
			if(index<0){
				index=list.size()-1;
				
			}
			
			imageSwitcher.setImageDrawable(list.get(index));
			break;
		case R.id.button2:
			index++;
			if(index>=list.size()){
				index=0;
				
			}
			
			imageSwitcher.setImageDrawable(list.get(index));
			break;
		default:
			break;
		}
		
	}

}
