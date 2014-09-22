package com.example.demo;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;

public class MyTest extends AndroidTestCase {

	private final String TAG = "MyTest";

	public MyTest() {
		// TODO Auto-generated constructor stub
	}

	public void saveFile() {

		Context context = getContext();
		FileService fileService = new FileService(context);
		boolean flag = fileService.savecontentToSdcard("hello.txt", "ÄãºÃ");
		Log.i(TAG, "--->>" + flag);
	}

	public void readFile() {

		Context context = getContext();
		FileService fileService = new FileService(context);
		String msgString = fileService.getFileFromSdcard("hello.txt");
		Log.i(TAG, "--->>" + msgString);
	}

}
