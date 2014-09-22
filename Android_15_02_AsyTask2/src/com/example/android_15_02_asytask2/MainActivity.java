package com.example.android_15_02_asytask2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.R.integer;
import android.os.AsyncTask;
import android.os.Bundle;
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
		dialog.setMessage("正在下载请稍后");
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.setCancelable(false);
		button.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new MyTask().execute(image_path);
			}
		});
	}
	
	public class MyTask extends AsyncTask<String, Integer, Bitmap>{

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog.show();
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			dialog.setProgress(values[0]);
		}
		
		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			dialog.dismiss();
			imageView.setImageBitmap(result);
		}
		
		
		
		
		
		@Override
		protected Bitmap doInBackground(String... params) {
			// TODO Auto-generated method stub
			//完成对图片的下载功能
			Bitmap bitmap = null;
			ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
			InputStream inputStream=null;
			try {
				HttpClient httpClient=new DefaultHttpClient();
				HttpGet httpGet=new HttpGet(params[0]);
				HttpResponse httpResponse=httpClient.execute(httpGet);
				
				if(httpResponse.getStatusLine().getStatusCode()==200){
					inputStream=httpResponse.getEntity().getContent();
					//先获得文件的总长度
					long file_length=httpResponse.getEntity().getContentLength();
					
					int len=0;
					byte[] data=new byte[1024];
					int total_length=0;
					
					while ((len=inputStream.read(data))!=-1) {
						total_length+=len;
						//刻度条
						int values=(int)((total_length/(float)file_length)*100);
						publishProgress(values);
						outputStream.write(data,0,len);
					}
					byte[] result=outputStream.toByteArray();
					bitmap=BitmapFactory.decodeByteArray(result, 0, result.length);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				
				if(outputStream!=null){
					try {
						outputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
				}
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
