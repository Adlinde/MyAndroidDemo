package com.example.dialog_window;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button button1, button2, button3, button4, button5, button7, button6, button8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1 = (Button) this.findViewById(R.id.button1);
		button2 = (Button) this.findViewById(R.id.button2);
//		button3 = (Button) this.findViewById(R.id.button3);
//		button4 = (Button) this.findViewById(R.id.button4);
		button5 = (Button) this.findViewById(R.id.button5);
		button6 = (Button) this.findViewById(R.id.button6);
		button7 = (Button) this.findViewById(R.id.button7);
		button8 = (Button) this.findViewById(R.id.button8);

		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
//		button3.setOnClickListener(this);
//		button4.setOnClickListener(this);
		button5.setOnClickListener(this);
		button6.setOnClickListener(this);
		button7.setOnClickListener(this);
		button8.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:

			AlertDialog.Builder builder = new Builder(MainActivity.this);
			builder.setMessage("确认退出吗？");
			builder.setTitle("提示");
			builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
					MainActivity.this.finish();
				}
			});
			builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
					dialog.dismiss();
				}
			});

			builder.create().show();

			break;
		case R.id.button2:
			AlertDialog.Builder builder2 = new Builder(MainActivity.this);
			builder2.setIcon(R.drawable.icon_sales);
			builder2.setTitle("投票");
			builder2.setMessage("您认为什么样的内容能吸引您？");
			builder2.setPositiveButton("有趣味的", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MainActivity.this, "有趣味的", Toast.LENGTH_SHORT).show();
				}
			});
			builder2.setNeutralButton("有思想的", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MainActivity.this, "有思想的", Toast.LENGTH_SHORT).show();
				}
			});
			builder2.setNegativeButton("主题强的", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MainActivity.this, "主题强的", Toast.LENGTH_SHORT).show();
				}
			});
			builder2.create().show();
			break;
//		case R.id.button3:
//			AlertDialog.Builder builder3 = new Builder(MainActivity.this);
//			final String[] mItems = { "item0", "item1", "itme2", "item3", "itme4", "item5", "item6" };
//			builder3.setTitle("列表选择框");
//			builder3.setItems(mItems, new DialogInterface.OnClickListener() {
//				public void onClick(DialogInterface dialog, int which) {
//					//点击后弹出窗口选择了第几项  
//					Toast.makeText(MainActivity.this, "你选择的id为" + which + " , " + mItems[which], Toast.LENGTH_SHORT).show();
//				}
//			});
//			builder3.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//				public void onClick(DialogInterface dialog, int whichButton) {
//				}
//			});
//			builder3.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//				public void onClick(DialogInterface dialog, int whichButton) {
//					dialog.dismiss();
//				}
//			});
//			break;

//		case R.id.button4:
//			break;
		case R.id.button5:
			final String[] mItems5 = { "item0", "item1", "itme2", "item3", "itme4", "item5", "item6" };
			AlertDialog.Builder builder5 = new AlertDialog.Builder(MainActivity.this);
			builder5.setIcon(R.drawable.icon_sales);
			builder5.setTitle("单项选择");
			builder5.setSingleChoiceItems(mItems5, 0, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					Toast.makeText(MainActivity.this, "你选择的id为" + whichButton + " , " + mItems5[whichButton], Toast.LENGTH_SHORT).show();
				}
			});
			builder5.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					if (whichButton > 0) {
						Toast.makeText(MainActivity.this, "你选择的是" + whichButton, Toast.LENGTH_SHORT).show();
					}
				}
			});
			builder5.setNegativeButton("取消", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					dialog.dismiss();
				}
			});
			builder5.create().show();
			break;
		case R.id.button6:
			final String[] arrayFruit = new String[] { "苹果", "橘子", "草莓", "香蕉" };
			final boolean[] arrayFruitSelected = new boolean[] { true, true, false, false };
			Builder builder6 = new AlertDialog.Builder(MainActivity.this);
			builder6.setTitle("你喜欢吃哪种水果？");
			builder6.setIcon(R.drawable.ic_launcher);
			builder6.setMultiChoiceItems(arrayFruit, arrayFruitSelected, new DialogInterface.OnMultiChoiceClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					arrayFruitSelected[which] = isChecked;
				}
			});
			builder6.setPositiveButton("确认", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					StringBuilder stringBuilder = new StringBuilder();
					for (int i = 0; i < arrayFruitSelected.length; i++) {
						if (arrayFruitSelected[i] == true) {
							stringBuilder.append(arrayFruit[i] + "、");
						}
					}
					Toast.makeText(MainActivity.this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();
				}
			});
			builder6.setNegativeButton("取消", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
				}
			});
			builder6.create().show();
			break;
		case R.id.button7:

			LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
			View myLoginView = layoutInflater.inflate(R.layout.logini, null);
			Builder builder7 = new AlertDialog.Builder(this);
			builder7.setTitle("用户登录");
			builder7.setIcon(R.drawable.ic_launcher);
			builder7.setView(myLoginView);
			builder7.setPositiveButton("登录", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
				}
			});
			builder7.setNegativeButton("取消", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
			builder7.create().show();
			break;
		case R.id.button8:
			ProgressDialog mProgressDialog8 = new ProgressDialog(MainActivity.this);
			mProgressDialog8.setTitle("读取ing");
			mProgressDialog8.setMessage("正在读取中请稍候");
			mProgressDialog8.show();
			break;

		}
	}
}
