package com.example.android_loader_manager;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.test.AndroidTestCase;

public class MyTest extends AndroidTestCase {

	public MyTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void add(){
		ContentResolver contentResolver=getContext().getContentResolver();
		ContentValues values=new ContentValues();
		values.put("name", "lisi");
		
		Uri uri=Uri.parse("content://com.example.android_loader_manager.StudentContentProvider/student");
		
		contentResolver.insert(uri, values);
		
	}
	
	public void del(){
		ContentResolver contentResolver=getContext().getContentResolver();
		
		Uri uri=Uri.parse("content://com.example.android_loader_manager.StudentContentProvider/student/1");
		
		int count=contentResolver.delete(uri, null, null);
		
		System.out.println("----->>>---"+count);
	}
	
	public void query(){
		ContentResolver contentResolver=getContext().getContentResolver();
		Uri uri=Uri.parse("content://com.example.android_loader_manager.StudentContentProvider/student");
		
		Uri url=ContentUris.withAppendedId(uri, 2);//²éÑ¯µ¥Ìõ
		
		Cursor cursor= contentResolver.query(url, null, null, null, null);
		while (cursor.moveToNext()) {
			System.out.println("--->---"+cursor.getString(cursor.getColumnIndex("name")));
		}
		
		
	}

}
