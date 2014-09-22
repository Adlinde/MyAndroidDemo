package com.example.activit;

import com.example.activit.entity.Person;
import com.example.activit.json.JsonTools;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button button1;
	//private Button button1, button2, button3, button4;
	
	private String path="µÿ÷∑";
	
	private  static final String TAG="MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1 = (Button) this.findViewById(R.id.button);
//		button2 = (Button) this.findViewById(R.id.button2);
//		button3 = (Button) this.findViewById(R.id.button3);
//		button4 = (Button) this.findViewById(R.id.button4);

		button1.setOnClickListener(this);
//		button2.setOnClickListener(this);
//		button3.setOnClickListener(this);
//		button4.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button:
			
			path=path+"?action_flag=person";
			String jsonString=HttpUtils.getXML(path);
			Person person=JsonTools.getPerson("person", jsonString);
			Log.i(TAG, person.toString());
			break;
//		case R.id.button2:
//
//			break;
//		case R.id.button3:
//
//			break;
//		case R.id.button4:
//
//			break;
		default:
			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
