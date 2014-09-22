package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import android.content.ContentValues;

public interface IPersonDao2 {

	public boolean add(ContentValues values);

	public boolean del(String whereClause,String[] whereArgs);

	public boolean update(ContentValues values,String whereClause,String[] whereArgs);

	public Map<String, String> viewPerson(String selection, String[] selectionArgs);

	public List<Map<String, String>> listPersonMaps(String selection, String[] selectionArgs);

}
