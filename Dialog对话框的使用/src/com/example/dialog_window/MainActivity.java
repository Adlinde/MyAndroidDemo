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
			builder.setMessage("ȷ���˳���");
			builder.setTitle("��ʾ");
			builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MainActivity.this, "ȷ��", Toast.LENGTH_SHORT).show();
					MainActivity.this.finish();
				}
			});
			builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MainActivity.this, "ȡ��", Toast.LENGTH_SHORT).show();
					dialog.dismiss();
				}
			});

			builder.create().show();

			break;
		case R.id.button2:
			AlertDialog.Builder builder2 = new Builder(MainActivity.this);
			builder2.setIcon(R.drawable.icon_sales);
			builder2.setTitle("ͶƱ");
			builder2.setMessage("����Ϊʲô������������������");
			builder2.setPositiveButton("��Ȥζ��", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MainActivity.this, "��Ȥζ��", Toast.LENGTH_SHORT).show();
				}
			});
			builder2.setNeutralButton("��˼���", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MainActivity.this, "��˼���", Toast.LENGTH_SHORT).show();
				}
			});
			builder2.setNegativeButton("����ǿ��", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MainActivity.this, "����ǿ��", Toast.LENGTH_SHORT).show();
				}
			});
			builder2.create().show();
			break;
//		case R.id.button3:
//			AlertDialog.Builder builder3 = new Builder(MainActivity.this);
//			final String[] mItems = { "item0", "item1", "itme2", "item3", "itme4", "item5", "item6" };
//			builder3.setTitle("�б�ѡ���");
//			builder3.setItems(mItems, new DialogInterface.OnClickListener() {
//				public void onClick(DialogInterface dialog, int which) {
//					//����󵯳�����ѡ���˵ڼ���  
//					Toast.makeText(MainActivity.this, "��ѡ���idΪ" + which + " , " + mItems[which], Toast.LENGTH_SHORT).show();
//				}
//			});
//			builder3.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
//				public void onClick(DialogInterface dialog, int whichButton) {
//				}
//			});
//			builder3.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
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
			builder5.setTitle("����ѡ��");
			builder5.setSingleChoiceItems(mItems5, 0, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					Toast.makeText(MainActivity.this, "��ѡ���idΪ" + whichButton + " , " + mItems5[whichButton], Toast.LENGTH_SHORT).show();
				}
			});
			builder5.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					if (whichButton > 0) {
						Toast.makeText(MainActivity.this, "��ѡ�����" + whichButton, Toast.LENGTH_SHORT).show();
					}
				}
			});
			builder5.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					dialog.dismiss();
				}
			});
			builder5.create().show();
			break;
		case R.id.button6:
			final String[] arrayFruit = new String[] { "ƻ��", "����", "��ݮ", "�㽶" };
			final boolean[] arrayFruitSelected = new boolean[] { true, true, false, false };
			Builder builder6 = new AlertDialog.Builder(MainActivity.this);
			builder6.setTitle("��ϲ��������ˮ����");
			builder6.setIcon(R.drawable.ic_launcher);
			builder6.setMultiChoiceItems(arrayFruit, arrayFruitSelected, new DialogInterface.OnMultiChoiceClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					arrayFruitSelected[which] = isChecked;
				}
			});
			builder6.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					StringBuilder stringBuilder = new StringBuilder();
					for (int i = 0; i < arrayFruitSelected.length; i++) {
						if (arrayFruitSelected[i] == true) {
							stringBuilder.append(arrayFruit[i] + "��");
						}
					}
					Toast.makeText(MainActivity.this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();
				}
			});
			builder6.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

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
			builder7.setTitle("�û���¼");
			builder7.setIcon(R.drawable.ic_launcher);
			builder7.setView(myLoginView);
			builder7.setPositiveButton("��¼", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
				}
			});
			builder7.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
			builder7.create().show();
			break;
		case R.id.button8:
			ProgressDialog mProgressDialog8 = new ProgressDialog(MainActivity.this);
			mProgressDialog8.setTitle("��ȡing");
			mProgressDialog8.setMessage("���ڶ�ȡ�����Ժ�");
			mProgressDialog8.show();
			break;

		}
	}
}
