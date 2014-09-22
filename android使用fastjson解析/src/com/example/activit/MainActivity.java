package com.example.activit;

import java.util.List;
import java.util.Map;

import org.json.JSONException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.activit.entity.Person;
import com.example.activit.gson.FastJsonTools;
import com.json.service.JsonService;
import com.json.service.JsonTools;

public class MainActivity extends Activity implements OnClickListener {
	//private Button button1;
	private Button button1, button2, button3;
	
	private String path="µÿ÷∑";
	
	private  static final String TAG="MainActivity";
	
	private JsonService service=new JsonService();
	
	public String msg="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1 = (Button) this.findViewById(R.id.button);
		button2 = (Button) this.findViewById(R.id.button2);
		button3 = (Button) this.findViewById(R.id.button3);
//		button4 = (Button) this.findViewById(R.id.button4);

		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
//		button4.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button:
			
//			path=path+"?action_flag=person";
//			String jsonString=HttpUtils.getXML(path);
			msg="{\"id\":1001,\"name\":\"jack\",\"adrees\":\"beijing\"}";
			
//			try {
//				
//				msg= JsonTools.createJsonString("Person", service.getPerson());
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			//Person person=FastJsonTools.getPerson(jsonString,Person.class);
			Person person=FastJsonTools.getPerson(msg,Person.class);
			Log.i(TAG, person.toString());
			break;
		case R.id.button2:
			path=path+"?action_flag=persons";
			String jsonString2=HttpUtils.getXML(path);
			List<Person> list2=FastJsonTools.getPersons(jsonString2,Person.class);
			Log.i(TAG, list2.toString());
			break;
		case R.id.button3:
			path=path+"?action_flag=listString";
			String jsonString3=HttpUtils.getXML(path);
			List<Map<String, Object>> list3=FastJsonTools.listKetMaps(jsonString3);
			Log.i(TAG, list3.toString());
			break;
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
