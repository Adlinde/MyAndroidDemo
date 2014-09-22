package com.example.android_09_10;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	private RadioGroup group;

	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		group = (RadioGroup) this.findViewById(R.id.sex);
		button = (Button) this.findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				int len = group.getChildCount();
				String msg = "";
				for (int i = 0; i < len; i++) {
					RadioButton reButton = (RadioButton) group.getChildAt(i);
					if (reButton.isChecked()) {
						msg = reButton.getText().toString();
						break;
					}

				}
				Toast.makeText(MainActivity.this, msg, 1).show();
			}
		});

		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				RadioButton radioBtn = (RadioButton) group.findViewById(checkedId);
				Toast.makeText(MainActivity.this, radioBtn.getText(), 1).show();
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
