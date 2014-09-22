package com.example.android_15_02_asytask2.tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

public class Http {

	private ResulCallBack mycallBack;

	public void post(String path, ResulCallBack callBack) {
		mycallBack = callBack;
		new MyTask().execute(path);
	}

	public interface ResulCallBack {
		void onPreExecute();

		void onProgressUpdate(Integer... values);

		void callback(Object object);
	}

	public class MyTask extends AsyncTask<String, Integer, Bitmap> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mycallBack.onPreExecute();
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			mycallBack.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			super.onPostExecute(result);
			mycallBack.callback(result);
		}

		@Override
		protected Bitmap doInBackground(String... params) {
			//完成对图片的下载功能
			Bitmap bitmap = null;
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			InputStream inputStream = null;
			try {
				HttpClient httpClient = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet(params[0]);
				HttpResponse httpResponse = httpClient.execute(httpGet);

				if (httpResponse.getStatusLine().getStatusCode() == 200) {
					inputStream = httpResponse.getEntity().getContent();
					//先获得文件的总长度
					long file_length = httpResponse.getEntity().getContentLength();

					int len = 0;
					byte[] data = new byte[1024];
					int total_length = 0;

					while ((len = inputStream.read(data)) != -1) {
						total_length += len;
						//刻度条
						int values = (int) ((total_length / (float) file_length) * 100);
						publishProgress(values);
						outputStream.write(data, 0, len);
					}
					byte[] result = outputStream.toByteArray();
					bitmap = BitmapFactory.decodeByteArray(result, 0, result.length);
				}

			} catch (Exception e) {
			} finally {

				if (outputStream != null) {
					try {
						outputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			return bitmap;
		}
	}
}
