package com.example.demo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.test.AndroidTestCase;

public class MyTest extends AndroidTestCase {

	public void insert() {

		//���������ṩ�ߵĲ���

		ContentResolver contentResolver = getContext().getContentResolver();
		//ʹ��content://+��Ȩ·��
		Uri url = Uri.parse("content://com.example.demo.StudentProvider/student");
		ContentValues values = new ContentValues();// ����map������
		values.put("name", "lisi");
		values.put("address", "beijing");
		values.put("sex", "��");
		contentResolver.insert(url, values);
	}

	
	
	
}
