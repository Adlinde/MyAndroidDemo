package com.example.demo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
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

	public void del() {

		//���������ṩ�ߵĲ���

		ContentResolver contentResolver = getContext().getContentResolver();
		//ʹ��content://+��Ȩ·�� ���������student/1  ��ɾ������
		Uri url = Uri.parse("content://com.example.demo.StudentProvider/student/1");

		contentResolver.delete(url, null, null);
	}

	private void update() {

		ContentResolver contentResolver = getContext().getContentResolver();

		Uri url = Uri.parse("content://com.example.demo.StudentProvider/student/2");

		ContentValues values = new ContentValues();// ����map������
		values.put("name", "lisi");
		values.put("address", "beijing");
		values.put("sex", "Ů");
		contentResolver.update(url, values, null, null);

	}

	public void query() {

		ContentResolver contentResolver = getContext().getContentResolver();
		//��ѯ������¼content://com.example.demo.StudentProvider/student/2
		//��ѯ������¼content://com.example.demo.StudentProvider/student
		Uri url = Uri.parse("content://com.example.demo.StudentProvider/student/1");
		
		Cursor cursor=contentResolver.query(url, null, null, null, null);
		
		while (cursor.moveToNext()) {
			System.out.println("----->"+cursor.getShort(cursor.getColumnIndex("name")));
		}
	}

}
