package com.example.android_15_01_asynctask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private Button button;
	private ImageView imageView;
	private String image_path="http://d.hiphotos.baidu.com/image/pic/item/c9fcc3cec3fdfc03510dd1c6d63f8794a4c22652.jpg";
	private ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) this.findViewById(R.id.button1);
		imageView = (ImageView) this.findViewById(R.id.imageView1);
		dialog=new ProgressDialog(this);
		dialog.setTitle("提示信息");
		dialog.setMessage("正在下载请稍后。。。。。");
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				//执行异步任务的操作
				new MyTask().execute(image_path);	
				
				//				//new Thread(new Runnable() {
				//	不能直接再UI主线程中访问网络				
				////					@Override
				////					public void run() {
				//						HttpClient httpClient=new DefaultHttpClient();
				//						HttpGet httpGet=new HttpGet(image_path);
				//						try {
				//							httpClient.execute(httpGet);
				//						} catch (ClientProtocolException e) {
				//							e.printStackTrace();
				//						} catch (IOException e) {
				//							e.printStackTrace();
				//						}
				////					}
				////				}).start();

			}
		});
	}

	/** \ 使用异步任务规则； 1.声明一个类继承AsyncTask 标注3个参数；
	 *  2.第一个任务表示要执行的任务通常是网络任务，二进度的刻度，三任务执行的返回结果
	 * @author 孙世东 */
	public class MyTask extends AsyncTask<String, Void, Bitmap> {
		//任务执行之前的操作
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog.show();
		}

		//主要更新Ui操作
		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			imageView.setImageBitmap(result);
			dialog.dismiss();
		}

		//完成耗时操作
		@Override
		protected Bitmap doInBackground(String... params) {
			// TODO Auto-generated method stub
			// 使用网络连接类HttpClient完成对网络数据的提取
			HttpClient httpClient=new DefaultHttpClient();
			HttpGet httpGet=new HttpGet(params[0]);
			Bitmap bitmap=null;
			try {
				HttpResponse httpResponse=httpClient.execute(httpGet);
				if(httpResponse.getStatusLine().getStatusCode()==200){
					HttpEntity httpEntity=httpResponse.getEntity();
					byte[] data=EntityUtils.toByteArray(httpEntity);
					bitmap=BitmapFactory.decodeByteArray(data, 0, data.length);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return bitmap;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
