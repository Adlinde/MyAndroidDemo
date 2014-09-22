package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity implements OnItemSelectedListener,
		OnItemClickListener{

	private GridView gridView;
	
	private ImageView imageView;
	
	private int[] resIds=new int[]{
			
			R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,
			R.drawable.image7,R.drawable.image8,R.drawable.image9
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gridView=(GridView)this.findViewById(R.id.gridview);
		
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		
		for (int i = 0; i < resIds.length; i++) {
			Map<String, Object> cell=new HashMap<String, Object>();
			cell.put("imageview", resIds[i]);
			list.add(cell);
		}
		
		
		SimpleAdapter simpleAdapter=new SimpleAdapter(MainActivity.this,
				list, R.layout.cell, new String[]{"imageview"},new int[]{R.id.imageview});
		
		
		imageView=(ImageView)this.findViewById(R.id.imageview);
		
		gridView.setAdapter(simpleAdapter);
		
		gridView.setOnItemClickListener(this);
		
		gridView.setOnItemSelectedListener(this);
		
		imageView.setImageResource(resIds[0]);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		imageView.setImageResource(resIds[position]);
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		imageView.setImageResource(position);
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

}
