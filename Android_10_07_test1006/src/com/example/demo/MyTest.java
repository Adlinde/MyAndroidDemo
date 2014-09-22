package com.example.demo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.test.AndroidTestCase;

public class MyTest extends AndroidTestCase {

	public void insert() {

		//访问内容提供者的步骤

		ContentResolver contentResolver = getContext().getContentResolver();
		//使用content://+授权路径
		Uri url = Uri.parse("content://com.example.demo.StudentProvider/student");
		ContentValues values = new ContentValues();// 类似map的属性
		values.put("name", "lisi");
		values.put("address", "beijing");
		values.put("sex", "男");
		contentResolver.insert(url, values);
	}

	
	
	
}
