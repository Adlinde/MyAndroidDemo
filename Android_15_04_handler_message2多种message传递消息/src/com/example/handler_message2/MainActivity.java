package com.example.handler_message2;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button button;
	
	private Handler handler=new Handler(){
		@Override
		public void handleMessage(Message msg) {
			Bundle bundle=msg.getData();
			
			
			System.out.println("--->"+bundle.getShortArray("str"));
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button=(Button)this.findViewById(R.id.button1);
		
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//启动一个子线程
				new Thread(new MyThread()).start();
			}
		});
	}

	
	public class MyThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
//			//第一种
//			Message message=Message.obtain( handler);
//			message.obj="sssss";
//			message.what=1;
//			message.arg1=2;
//			message.arg2=3;
//			handler.sendMessage(message);
			
			
//			//第二种
//			Message message=Message.obtain( handler);
//			message.obj="sssss";
//			message.what=1;
//			message.arg1=2;
//			message.arg2=3;
//			message.sendToTarget();
			
//			//第三种
//			Message message=Message.obtain( handler,33);
//			message.obj="ddd";
//			message.arg1=1;
//			message.arg2=2;
//			message.sendToTarget();
//			//第四种
//			Message message=Message.obtain( handler,2,"tome");
//			message.sendToTarget();
			
			//第五种
			Message message=Message.obtain( handler,9,1,2,"tome");
			Bundle data=new Bundle();
			data.putStringArray("str", new String[]{"jack","rose","boyb"});
			message.setData(data);
			message.sendToTarget();
			
			
		}
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
