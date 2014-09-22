package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.demo.dao.IPersonDao;
import com.example.demo.db.DbopenHelper;

public class PersonDaoImpl implements IPersonDao {

	private DbopenHelper helper = null;

	public PersonDaoImpl(Context context) {
		// TODO Auto-generated constructor stub
		helper = new DbopenHelper(context);
	}

	@Override
	public boolean add(Object[] params) {
		// TODO Auto-generated method stub
		boolean flag = false;

		SQLiteDatabase database = null;

		try {
			String sql = "insert into person(name,address,sex) values(?,?,?)";
			database = helper.getWritableDatabase();//实现对数据库写的操作
			database.execSQL(sql, params);
			flag = true;

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
	public boolean del(Object[] params) {
		boolean flag = false;

		SQLiteDatabase database = null;

		try {
			String sql = "delete from person where id=?";
			database = helper.getWritableDatabase();//实现对数据库写的操作
			database.execSQL(sql, params);
			flag = true;

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
	public boolean update(Object[] params) {
		boolean flag = false;

		SQLiteDatabase database = null;

		try {
			String sql = "update person set name=?,address=?,sex=? where id=?";
			database = helper.getWritableDatabase();//实现对数据库写的操作
			database.execSQL(sql, params);
			flag = true;

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
	public Map<String, String> viewPerson(String[] selectionArgs) {
		Map<String, String> map=new HashMap<String, String>();
		SQLiteDatabase database = null;

		try {
			String sql = "select * from person where id=?";
			database = helper.getWritableDatabase();//实现对数据库写的操作
			Cursor cursor=database.rawQuery(sql, selectionArgs);
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
	public List<Map<String, String>> listPersonMaps(String[] selectionArgs) {
		List<Map<String, String>> list=new ArrayList<Map<String,String>>();
		
		SQLiteDatabase database = null;

		try {
			String sql = "select * from person ";
			database = helper.getWritableDatabase();//实现对数据库写的操作
			Cursor cursor=database.rawQuery(sql, selectionArgs);
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
