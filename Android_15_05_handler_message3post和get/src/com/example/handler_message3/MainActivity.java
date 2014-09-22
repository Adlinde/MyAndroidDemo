package com.example.handler_message3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	private Button button;
	
	private Button button2;
	//handler ���Խ��ջ��߷�����Ϣ������Ϣ�ж�����ȡ��Ϣ�����ڸ���UI�Ĳ���
	private Handler handler=new Handler(){
		
		@Override
		public void handleMessage(android.os.Message msg) {
			
			System.out.println("---what--"+msg.what);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button=(Button)this.findViewById(R.id.button1);
		button2=(Button)this.findViewById(R.id.button2);
		
		button.setOnClickListener(this);
		button2.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			//����һ���߳�
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// ��ͬ�ķ��ͷ�ʽ
					 //handler.sendEmptyMessage(3);
					//handler.sendEmptyMessageAtTime(3, 1000);
					//handler.sendEmptyMessageDelayed(3, 3000);//������ͣ�����Ϣ����
					
					
					//Message msg=Message.obtain();
					Message msg=handler.obtainMessage();
					msg.what=3;
					msg.obj="jack";
					msg.arg1=1;
					handler.sendMessage(msg);
				}
			});
			break;
		case R.id.button2:
			
			handler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					//handler.postDelayed("ss",3000);
					button2.setText("ssss");
				}
			});
			break;
		}
		
	}

}
