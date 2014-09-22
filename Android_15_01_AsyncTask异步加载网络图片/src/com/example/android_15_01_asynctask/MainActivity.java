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
		dialog.setTitle("��ʾ��Ϣ");
		dialog.setMessage("�����������Ժ󡣡�������");
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				//ִ���첽����Ĳ���
				new MyTask().execute(image_path);	
				
				//				//new Thread(new Runnable() {
				//	����ֱ����UI���߳��з�������				
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

	/** \ ʹ���첽������� 1.����һ����̳�AsyncTask ��ע3��������
	 *  2.��һ�������ʾҪִ�е�����ͨ�����������񣬶����ȵĿ̶ȣ�������ִ�еķ��ؽ��
	 * @author ������ */
	public class MyTask extends AsyncTask<String, Void, Bitmap> {
		//����ִ��֮ǰ�Ĳ���
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog.show();
		}

		//��Ҫ����Ui����
		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			imageView.setImageBitmap(result);
			dialog.dismiss();
		}

		//��ɺ�ʱ����
		@Override
		protected Bitmap doInBackground(String... params) {
			// TODO Auto-generated method stub
			// ʹ������������HttpClient��ɶ��������ݵ���ȡ
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
