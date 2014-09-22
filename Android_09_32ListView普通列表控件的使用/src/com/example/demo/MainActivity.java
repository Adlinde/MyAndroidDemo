package com.example.demo;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	private ListView listView;
	
	private ArrayAdapter<String> adapter;
	
	//表示数据源
	private List<String> data=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		data=MyDataSource.getDataSource();
		
//1		adapter=new ArrayAdapter<String>(MainActivity.this,
//				android.R.layout.simple_list_item_1,data);
		
		//给每一个选项添加单选操作
//		adapter=new ArrayAdapter<String>(MainActivity.this,
//				android.R.layout.simple_list_item_single_choice,data);
		
		//给每一个选项添加多选操作
		adapter=new ArrayAdapter<String>(MainActivity.this,
			android.R.layout.simple_list_item_multiple_choice,data);
		
		listView=(ListView)this.findViewById(R.id.listview);
		
		
		//给每一个选项添加单选操作
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		//给每一个选项添加多选操作
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		
		
		//长按事件
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				
				Toast.makeText(MainActivity.this, "click me", 1).show();
				
				return false;
			}
		});
		
		
		listView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
