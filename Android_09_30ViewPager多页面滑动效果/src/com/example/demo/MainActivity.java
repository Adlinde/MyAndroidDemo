package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.R.layout;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	private ViewPager viewPager;
	
	private PagerTitleStrip pagerTitleStrip;//表示滑动的每一页的标题
	
	private List<View> list;//表示装载滑动的布局
	
	private List<String> titleList;//表示滑动的每一页的标题
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		viewPager=(ViewPager)this.findViewById(R.id.viewpager);
		
		pagerTitleStrip=(PagerTitleStrip)this.findViewById(R.id.viewpagertitle);
		
		//动态加载布局
		
		View view1=LayoutInflater.from(MainActivity.this)
				.inflate(layout.tab1, null);
		View view2=LayoutInflater.from(MainActivity.this)
				.inflate(layout.tab2, null);
		View view3=LayoutInflater.from(MainActivity.this)
				.inflate(layout.tab3, null);
		
		list=new ArrayList<View>();
		list.add(view1);
		list.add(view2);
		list.add(view3);
		
		
		titleList=new ArrayList<String>();
		titleList.add("title1");
		titleList.add("title2");
		titleList.add("title3");
		
		
		viewPager.setAdapter(new MyAdapter());
	}
	
	
	public class MyAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			
			return list.size();
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			// TODO Auto-generated method stub
			//super.destroyItem(container, position, object);
			
			((ViewPager)container).removeView(list.get(position));
			
		}
		
		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub
			return titleList.get(position);
		}
		
		@Override
		public Object instantiateItem(View container, int position) {
			// TODO Auto-generated method stub
			
			((ViewPager)container).addView(list.get(position));
			return list.get(position);
		}
		

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}
	}
	

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
