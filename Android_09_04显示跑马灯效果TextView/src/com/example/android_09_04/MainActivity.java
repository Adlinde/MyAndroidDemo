package com.example.android_09_04;


import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView=(TextView)this.findViewById(R.id.textview);
		
		String html="error opening trace file: No such file or directory (2) ����Eclipse�г������������, ��ֻ֪����Linuxϵͳ���и�trace����,���ٳ��ֵ�...";
		CharSequence charSequence=Html.fromHtml(html);
		textView.setText(charSequence);
		textView.setMovementMethod(LinkMovementMethod.getInstance());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
