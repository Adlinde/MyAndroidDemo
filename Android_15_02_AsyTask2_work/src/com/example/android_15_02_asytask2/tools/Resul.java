package com.example.android_15_02_asytask2.tools;

import android.app.Activity;
import android.app.ProgressDialog;

import com.example.android_15_02_asytask2.tools.Http.ResulCallBack;

public class Resul {

	private ProgressDialog dialog;

	public Resul(Activity activity) {

		dialog = new ProgressDialog(activity);
		dialog.setTitle("提示信息");
		dialog.setMessage("正在下载请稍后");
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.setCancelable(false);
	}

	private static Http http;

	public static void post(String url) {
		http = new Http();
		http.post(url, new ResulCallBack() {
			
			@Override
			public void onProgressUpdate(Integer... values) {
				
			}
			
			@Override
			public void onPreExecute() {
				
			}
			
			@Override
			public void callback(Object object) {
				
			}
		});
		
		
	}
	
	public interface Call{
		T back(Object object);
	}

}
