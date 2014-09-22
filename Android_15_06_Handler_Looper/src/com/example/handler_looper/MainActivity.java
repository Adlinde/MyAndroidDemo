package com.example.handler_looper;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button button;
	
	private TextView textView;
	
	private Handler handler;
//private MyHandler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//在activity有一个默认的Looper的对象，来处理子线程中发送的消息
		button=(Button)this.findViewById(R.id.button1);
		textView=(TextView)this.findViewById(R.id.textView1);
		new Thread(new MyThread()).start();
		
//		Looper looper=Looper.myLooper();
//		handler=new MyHandler();
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				//启动线程
//				new Thread(new MyThread()).start();
				
				Message message=Message.obtain();
				message.obj="jack";
				handler.sendMessage(message);
				
			}
		});
		
	}
	
	//UI子线程
	public class MyThread implements Runnable{

		@Override
		public void run() {
			Looper.prepare();// 循环消息队列
			//子线程实例化
			handler=new Handler(){
				@Override
				public void handleMessage(Message msg) {
					// TODO Auto-generated method stub
					super.handleMessage(msg);
					System.out.println("从UI主线程获取消息"+msg.obj);
				}
			};
			Looper.loop();//直到消息队列循环结束
			
//			// TODO Auto-generated method stub
//			Message message=Message.obtain();
//			message.obj="jack";
//			handler.sendMessage(message);
		}
	}

//	public class MyHandler extends Handler{
//		public MyHandler() {
//		}
//		public MyHandler(Looper looper) {
//			// TODO Auto-generated constructor stub
//			super(looper);
//		}
//		
//		@Override
//		public void handleMessage(Message msg) {
//			// TODO Auto-generated method stub
//			super.handleMessage(msg);
//			textView.setText("--接收消息--"+msg.obj);
//		}
//	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
