package com.example.android_01_09;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private Button button;

	private final static int REQUESTCORD = 1;//返回结果码

	private EditText one, two, result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button = (Button) this.findViewById(R.id.button);
		one = (EditText) this.findViewById(R.id.one);
		two = (EditText) this.findViewById(R.id.two);
		result = (EditText) this.findViewById(R.id.result);

		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				int a = Integer.parseInt(one.getText().toString());
				int b = Integer.parseInt(two.getText().toString());
				Intent intent = new Intent(MainActivity.this, OtherActivity.class);
				intent.putExtra("a", a);
				intent.putExtra("b", b);
				startActivityForResult(intent, REQUESTCORD);//表示可以返回结果	
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == 2) {

			int three = data.getIntExtra("three", 0);
			result.setText(String.valueOf(three));

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
