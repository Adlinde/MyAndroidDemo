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
		//���ز���
		inflater=LayoutInflater.from(MainActivity.this);
		//��һ�α����صĲ��ֶ���
		View tab=inflater.inflate(R.layout.tab1, null);
		
		list=new ArrayList<View>();
		list.add(tab);
		
		title=new ArrayList<String>();
		title.add("title");
		
		
		//�ȳ�ʼ��ҳ��
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
			
			//��ǰһ��ҳ����ȫ�˳���ż��ء������ҳ���������
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
				//�����￪���߳�ȥ������������ݣ�����UI�Ĳ���
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

		//��ʼ��������
		@Override
		public Object instantiateItem(View container, int position) {
			// TODO Auto-generated method stub
			
			((ViewPager)container).addView(list.get(position));
			return list.get(position);
		}
		//���ٻ����Ľ�Ŀ
		@Override
		public void destroyItem(View container, int position, Object object) {
			// TODO Auto-generated method stub
			//super.destroyItem(container, position, object);
			((ViewPager)container).removeView(list.get(position));
		}
		//�õ�ÿ������ı���
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
