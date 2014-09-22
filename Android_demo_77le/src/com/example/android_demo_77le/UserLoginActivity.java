package com.example.android_demo_77le;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class UserLoginActivity extends Activity {
	
	private Button button1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_longin_activity);
		button1=(Button)this.findViewById(R.id.userzhucebtn);
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(UserLoginActivity.this, UserRegisterActivity.class);
				startActivity(intent);
			}
		});
	}

}
