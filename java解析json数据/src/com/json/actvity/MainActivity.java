package com.json.actvity;

import org.json.JSONException;

import com.json.service.JsonService;
import com.json.tools.JsonTools;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView=(TextView)this.findViewById(R.id.textview);
		
		String msg="";
		JsonService service=new JsonService();
		try {
			msg= JsonTools.createJsonString("Persons", service.getPersonList());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textView.setText(msg);
		Log.i("msg", msg);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
