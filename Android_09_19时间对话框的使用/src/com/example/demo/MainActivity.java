package com.example.demo;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity  implements OnClickListener{

	private Button button1,button2;
	
	private int hourOfDay,minute;
	
	
	private int year,monthOfYear,dayOfMonth;
	 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1=(Button)this.findViewById(R.id.button1);
		button2=(Button)this.findViewById(R.id.button2);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		//获得当前时间，获得当前小时和分钟
		
		Calendar calendar=Calendar.getInstance();
		hourOfDay= calendar.get(Calendar.HOUR_OF_DAY);
		minute=calendar.get(Calendar.MINUTE);//当前秒
		year=calendar.get(Calendar.YEAR);
		monthOfYear=calendar.get(Calendar.MONTH);
		dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.button1:
			TimePickerDialog timePickerDialog=new TimePickerDialog(MainActivity.this,
					new MyTimePickerDialog(), hourOfDay, minute, true);
			
			timePickerDialog.show();//显示对话框
			break;
		case R.id.button2:
			
			DatePickerDialog datePickerDialo=new DatePickerDialog(MainActivity.this,
					new MyDatePickerDialog(), year, monthOfYear, dayOfMonth);
			
			datePickerDialo.show();
			break;

		default:
			break;
		}
	}
	
	//时间内部类
	public class MyTimePickerDialog implements 
	TimePickerDialog.OnTimeSetListener{

		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			Toast.makeText(MainActivity.this, "hourOfDay"+hourOfDay+"minute"+minute, 1).show();
			
		}
		
		
	}
	
	//日期内部类
	
	public class MyDatePickerDialog implements 
	DatePickerDialog.OnDateSetListener{

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			
		}
		
		
	}

}
