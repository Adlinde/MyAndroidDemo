package com.example.android_09_10;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnClickListener {

	private List<CheckBox> checkBoxs=new ArrayList<CheckBox>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		String[] checkboxText=new String[]{"你是学生吗","喜欢出国吗","喜欢安卓吗","喜欢旅游么","你是二货吗"};
		//添加布局
		LinearLayout linearLayout=(LinearLayout)getLayoutInflater().inflate(R.layout.activity_main, null);
		//给指定的checkbox赋值
		for (int i = 0; i < checkboxText.length; i++) {
			CheckBox checkBox=(CheckBox)getLayoutInflater().inflate(R.layout.checkbox, null);
			
			checkBoxs.add(checkBox);
			checkBoxs.get(i).setText(checkboxText[i]);
			//实现动态添加线性布局
			linearLayout.addView(checkBox,i);
			
		}
		setContentView(linearLayout);
		Button button=(Button)this.findViewById(R.id.button);
		button.setOnClickListener(this);

	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void onClick(View v) {
		String s="";
		for (CheckBox checkBox : checkBoxs) {
			if(checkBox.isChecked()){
				s+=checkBox.getText()+"\n";
			}
		}
		if("".equals(s)){
			s="你还没选择任何选项";
		}
		//使用一个提示框提示用户的信息
		new AlertDialog.Builder(this).setMessage(s).setPositiveButton("关闭", null).show();
		
	}

}
