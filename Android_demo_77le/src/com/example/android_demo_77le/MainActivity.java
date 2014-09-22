package com.example.android_demo_77le;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private LinearLayout layout;

	private FragmentManager fm;

	//private FragmentTransaction ft;
	
	private RadioButton rButton1,rButton4;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		layout = (LinearLayout) this.findViewById(R.id.mainlout);
		
		rButton1=(RadioButton)this.findViewById(R.id.radioButton1);
		rButton4=(RadioButton)this.findViewById(R.id.radioButton4);

		fm = getSupportFragmentManager();

		FragmentTransaction ft = fm.beginTransaction();

		ft.replace(R.id.mainlout, new LotteHalFragment());

		ft.commit();
		rButton1.setOnClickListener(this);
		rButton4.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.radioButton1:			
			fm.beginTransaction().replace(R.id.mainlout, new LotteHalFragment());
			fm.beginTransaction().commit();
			break;

		case R.id.radioButton4:

			Intent intent=new Intent(MainActivity.this, UserLoginActivity.class);
			startActivity(intent);
			break;
		}	
		
		
	}

}
