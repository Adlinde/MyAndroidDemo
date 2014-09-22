package com.example.demo.dao;

import java.util.List;
import java.util.Map;

public interface IPersonDao {
	
	
	public boolean add(Object[] params);
	
	public boolean del(Object[] params);
	
	public boolean update(Object[] params);
	
	public Map<String, String> viewPerson(String[] selectionArgs);
	
	public List<Map<String, String>> listPersonMaps(String[] selectionArgs);

}
