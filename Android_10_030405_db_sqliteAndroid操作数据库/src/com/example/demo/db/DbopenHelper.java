package com.example.demo.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DbopenHelper extends SQLiteOpenHelper {

	
	private static String name="mydbs.db";//数据库的名称
	
	private static int version=2;//数据库版本号从1开始
	
	//上下文参数context  
	public DbopenHelper(Context context) {
		super(context, name, null, version);
		// TODO Auto-generated constructor stub
	}

	//当数据库诶创建的时候第一次被执行，完成对数据库表的创建
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		
		//支持数据类型  整形，字符串，日期，二进制
		String sql="create table person(id integer primary key autoincrement,name varchar(60),address varchar(64))";
		
		db.execSQL(sql);
		

	}

	
	//版本高于钱一版本号是执行，不执行onCreate
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
		String sql="alter table person add sex varchar(8)";
		db.execSQL(sql);

	}

}
