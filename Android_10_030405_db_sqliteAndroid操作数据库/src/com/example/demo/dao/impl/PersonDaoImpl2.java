package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.demo.dao.IPersonDao2;
import com.example.demo.db.DbopenHelper;

public class PersonDaoImpl2 implements IPersonDao2 {

	private DbopenHelper helper = null;

	public PersonDaoImpl2(Context context) {
		// TODO Auto-generated constructor stub
		helper = new DbopenHelper(context);
	}

	@Override
	public boolean add(ContentValues values) {
		// TODO Auto-generated method stub
		boolean flag = false;

		SQLiteDatabase database = null;
		long id=-1;
		try {
			database = helper.getWritableDatabase();//实现对数据库写的操作
			database.insert("person", null, values);
			flag = (id!=1?true:false);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (database != null) {
				database.close();
			}
		}
		return flag;
	}

	@Override
	public boolean del(String whereClause,String[] whereArgs) {
		boolean flag = false;

		SQLiteDatabase database = null;
		int count=0;
		try {
			database = helper.getWritableDatabase();//实现对数据库写的操作
			database.delete("person", whereClause, whereArgs);
			flag=(count>0?true:false);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (database != null) {
				database.close();
			}
		}
		return flag;
	}

	@Override
	public boolean update(ContentValues values,String whereClause,String[] whereArgs) {
		boolean flag = false;
		SQLiteDatabase database = null;
		int count=0;
		try {
			database = helper.getWritableDatabase();//实现对数据库写的操作
			database.update("person", values, whereClause, whereArgs);
			flag=(count>0?true:false);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (database != null) {
				database.close();
			}
		}
		return flag;
	}

	@Override
	public Map<String, String> viewPerson(String selection, String[] selectionArgs) {
		Map<String, String> map=new HashMap<String, String>();
		SQLiteDatabase database = null;
		Cursor cursor=null;
		try {
			database = helper.getWritableDatabase();//实现对数据库写的操作
			cursor=database.query(false, "person"
					, null, selection
					, selectionArgs, null
					, null, null
					, null);
			//获得数据库的列数
			int colums=cursor.getColumnCount();
			while (cursor.moveToNext()) {
				for (int i = 0; i < colums; i++) {
					String cols_name=cursor.getColumnName(i);
					//提取真正的数据
					String cols_value=cursor.getString(cursor.getColumnIndex(cols_name));
					if(cols_value==null){
						cols_value="";
						
					}
					map.put(cols_name, cols_value);
				}
			}
			

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (database != null) {
				database.close();
			}
		}
		return map;
	}

	@Override
	public List<Map<String, String>> listPersonMaps(String selection, String[] selectionArgs) {
		List<Map<String, String>> list=new ArrayList<Map<String,String>>();
		
		SQLiteDatabase database = null;
		Cursor cursor=null;
		try {
			database = helper.getWritableDatabase();//实现对数据库写的操作
			cursor=database.query(false, "person"
					, null, selection
					, selectionArgs, null
					, null, null
					, null);
			//获得数据库的列数
			int colums=cursor.getColumnCount();
			while (cursor.moveToNext()) {
				
				Map<String, String> map=new HashMap<String, String>();
				
				for (int i = 0; i < colums; i++) {
					String cols_name=cursor.getColumnName(i);
					//提取真正的数据
					String cols_value=cursor.getString(cursor.getColumnIndex(cols_name));
					if(cols_value==null){
						cols_value="";
					}
					map.put(cols_name, cols_value);
				}
				list.add(map);
			}
			

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (database != null) {
				database.close();
			}
		}
		
		
		return list;
	}

}
