package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	private ViewPager viewPager;
	
	private PagerTitleStrip pagerTitleStrip;
	
	private MyAdapter adapter=null;
	
	private List<View> list=null;
	
	private List<String> title=null;
	
	private LayoutInflater inflater=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewPager=(ViewPager)this.findViewById(R.id.viewpager);
		pagerTitleStrip=(PagerTitleStrip)this.findViewById(R.id.viewpagertitle);
		
		adapter=new MyAdapter();
		//加载布局
		inflater=LayoutInflater.from(MainActivity.this);
		//第一次被加载的布局对象
		View tab=inflater.inflate(R.layout.tab1, null);
		
		list=new ArrayList<View>();
		list.add(tab);
		
		title=new ArrayList<String>();
		title.add("title");
		
		
		//先初始化页面
		viewPager.setAdapter(adapter);
		
		
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				Log.i("MainActivity","--arg0-->"+arg0);
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				Log.i("MainActivity","--arg0-->"+arg0);
				Log.i("MainActivity","--arg1-->"+arg1);
				Log.i("MainActivity","--arg2-->"+arg2);
				Log.i("MainActivity","---------->-------------");
			}
			
			//当前一个页面完全退出后才加载。在这个页面加载数据
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
				//在这里开启线程去下载网络的数据，跟新UI的操作
				View view=inflater.inflate(R.layout.tab1, null);
				list.add(view);
				title.add("new title");
				
				adapter.notifyDataSetChanged();
				
				Log.i("MainActivity","--arg0-->"+arg0);
				Log.i("MainActivity","--+------->------------------");
				
			}
		});
		
		
	}
	
	public class MyAdapter extends PagerAdapter{

		//初始化适配器
		@Override
		public Object instantiateItem(View container, int position) {
			// TODO Auto-generated method stub
			
			((ViewPager)container).addView(list.get(position));
			return list.get(position);
		}
		//销毁划过的节目
		@Override
		public void destroyItem(View container, int position, Object object) {
			// TODO Auto-generated method stub
			//super.destroyItem(container, position, object);
			((ViewPager)container).removeView(list.get(position));
		}
		//得到每个界面的标题
		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub
			return title.get(position);
		}
		
		@Override
		public int getCount() {
			return list.size();
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
