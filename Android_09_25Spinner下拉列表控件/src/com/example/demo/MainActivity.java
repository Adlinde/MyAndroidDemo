package com.example.demo;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.example.adapter.MyAdapter;

public class MainActivity extends Activity {

	private Spinner spinner;
	
	private Spinner spinner2;
	
	//private 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		spinner=(Spinner)this.findViewById(R.id.spinner);
		
		
		
		List<String> list=MyAdapter.getData();
		
		ArrayAdapter<String> adapter
		=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,list);
		
		
		spinner.setAdapter(adapter);
		
		spinner2=(Spinner)this.findViewById(R.id.spinner2);
		
		List<Map<String,Object>> listmaps=MyAdapter.getlistMaps();
		
		SimpleAdapter simpleAdapter=new SimpleAdapter(MainActivity.this, listmaps, R.layout.item,
				new String[]{"ivlogo","applicationName"}, new int[]{R.id.imageview,R.id.textview});
		
		spinner2.setAdapter(simpleAdapter);
		
		
		spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				
			String appname	=((Map<String,Object>)spinner2.getItemAtPosition(position)).get("applicationName").toString();
				
				setTitle(appname);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
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
