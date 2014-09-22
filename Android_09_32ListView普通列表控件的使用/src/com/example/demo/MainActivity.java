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
	
	//��ʾ����Դ
	private List<String> data=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		data=MyDataSource.getDataSource();
		
//1		adapter=new ArrayAdapter<String>(MainActivity.this,
//				android.R.layout.simple_list_item_1,data);
		
		//��ÿһ��ѡ����ӵ�ѡ����
//		adapter=new ArrayAdapter<String>(MainActivity.this,
//				android.R.layout.simple_list_item_single_choice,data);
		
		//��ÿһ��ѡ����Ӷ�ѡ����
		adapter=new ArrayAdapter<String>(MainActivity.this,
			android.R.layout.simple_list_item_multiple_choice,data);
		
		listView=(ListView)this.findViewById(R.id.listview);
		
		
		//��ÿһ��ѡ����ӵ�ѡ����
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		//��ÿһ��ѡ����Ӷ�ѡ����
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		
		
		//�����¼�
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
