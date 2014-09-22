package com.example.demo.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DbopenHelper extends SQLiteOpenHelper {

	
	private static String name="mydbs.db";//���ݿ������
	
	private static int version=2;//���ݿ�汾�Ŵ�1��ʼ
	
	//�����Ĳ���context  
	public DbopenHelper(Context context) {
		super(context, name, null, version);
		// TODO Auto-generated constructor stub
	}

	//�����ݿ���������ʱ���һ�α�ִ�У���ɶ����ݿ��Ĵ���
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		
		//֧����������  ���Σ��ַ��������ڣ�������
		String sql="create table person(id integer primary key autoincrement,name varchar(60),address varchar(64))";
		
		db.execSQL(sql);
		

	}

	
	//�汾����Ǯһ�汾����ִ�У���ִ��onCreate
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
		String sql="alter table person add sex varchar(8)";
		db.execSQL(sql);

	}

}
