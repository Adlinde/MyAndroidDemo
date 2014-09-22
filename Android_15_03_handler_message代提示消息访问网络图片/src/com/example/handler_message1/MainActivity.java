package com.example.handler_message1;

import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;
import org.apache.http.util.EntityUtils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	private Button button;
	
	private String image_path="http://d.hiphotos.baidu.com/image/pic/item/c9fcc3cec3fdfc03510dd1c6d63f8794a4c22652.jpg";
	
	private ImageView imageView;
	
	private final int IS_FINISH=1;
	private ProgressDialog dialog=null;
	
	private Handler handler=new Handler(){
		@Override
		public void handleMessage(android.os.Message msg) {
			byte[] data=(byte[]) msg.obj;
			Bitmap bitmap=BitmapFactory.decodeByteArray(data, 0, data.length);
			imageView.setImageBitmap(bitmap);
			
			if(msg.what==IS_FINISH){
				
				dialog.dismiss();
			}
		}
	};

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button=(Button)this.findViewById(R.id.button1);
		dialog=new ProgressDialog(this);
		dialog.setTitle("提示");
		dialog.setMessage("正在下载");
		dialog.setCancelable(false);
		imageView=(ImageView)this.findViewById(R.id.imageView1);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Thread(new MyThread()).start();
				dialog.show();
			}
		});
	}
	
	public class MyThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			HttpClient httpClient=new DefaultHttpClient();
			HttpGet httpGet=new HttpGet(image_path);
			HttpResponse httpResponse=null;
			//InputStream inputStream=null;
			try {
				httpResponse=httpClient.execute(httpGet);
				if(httpResponse.getStatusLine().getStatusCode()==200){
					//inputStream=httpResponse.getEntity().getContent();
					byte[] data=EntityUtils.toByteArray(httpResponse.getEntity());
					
					Message message=Message.obtain();
					message.obj=data;
					message.what=IS_FINISH;
					handler.sendMessage(message);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
