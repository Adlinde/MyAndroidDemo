package com.example.demo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
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

	public void del() {

		//访问内容提供者的步骤

		ContentResolver contentResolver = getContext().getContentResolver();
		//使用content://+授权路径 如果不传递student/1  则删除所有
		Uri url = Uri.parse("content://com.example.demo.StudentProvider/student/1");

		contentResolver.delete(url, null, null);
	}

	private void update() {

		ContentResolver contentResolver = getContext().getContentResolver();

		Uri url = Uri.parse("content://com.example.demo.StudentProvider/student/2");

		ContentValues values = new ContentValues();// 类似map的属性
		values.put("name", "lisi");
		values.put("address", "beijing");
		values.put("sex", "女");
		contentResolver.update(url, values, null, null);

	}

	public void query() {

		ContentResolver contentResolver = getContext().getContentResolver();
		//查询单挑记录content://com.example.demo.StudentProvider/student/2
		//查询多条记录content://com.example.demo.StudentProvider/student
		Uri url = Uri.parse("content://com.example.demo.StudentProvider/student/1");
		
		Cursor cursor=contentResolver.query(url, null, null, null, null);
		
		while (cursor.moveToNext()) {
			System.out.println("----->"+cursor.getShort(cursor.getColumnIndex("name")));
		}
	}

}
