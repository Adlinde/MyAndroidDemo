package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnDateChangedListener,OnTimeChangedListener{

	private TextView textView;
	private DatePicker datePicker;
	private TimePicker timePicker;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView=(TextView)this.findViewById(R.id.textview);
		
		datePicker=(DatePicker)this.findViewById(R.id.datepicker);
		
		timePicker=(TimePicker)this.findViewById(R.id.timeicker);
		
		
		datePicker.init(2001, 1, 25, this);//初始化日期
		
		timePicker.setIs24HourView(true);//显示日期是否是安卓24小时
		timePicker.setOnTimeChangedListener(this);//注册事件
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	//时间控件的促发
	@Override
	public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
		
		Toast.makeText(MainActivity.this,
				"hourOfDay"+hourOfDay+"minute"+minute, 1).show();
	}

	//日期控件的促发
	@Override
	public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
		Calendar calendar=Calendar.getInstance();
		
		calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(),
				timePicker.getCurrentHour(), timePicker.getCurrentMinute());
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		textView.setText( sdf.format(calendar.getTime()));
		
	}

}
