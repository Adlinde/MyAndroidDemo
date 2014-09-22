package com.example.demo.test;

import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.test.AndroidTestCase;

import com.example.demo.dao.IPersonDao;
import com.example.demo.dao.IPersonDao2;
import com.example.demo.dao.impl.PersonDaoImpl;
import com.example.demo.dao.impl.PersonDaoImpl2;

public class MyTest2 extends AndroidTestCase {

	private IPersonDao2 dao=new PersonDaoImpl2(getContext());
	public String TAG="MyTest";	
	public MyTest2() {
		// TODO Auto-generated constructor stub
	}
	
	public void insertDB(){
		
		ContentValues values=new ContentValues();// 类似map的属性
		values.put("name", "lisi");
		values.put("address", "beijing");
		values.put("sex", "男");
		boolean flag=dao.add(values);
		System.out.println("---->"+flag);
	}
	
	public void delDB(){
		boolean flag=dao.del("id=?",new  String[]{"4"});
		System.out.println("---->"+flag);
	}
	
	public void updaDB(){
		ContentValues values=new ContentValues();// 类似map的属性
		values.put("name", "小花");
		values.put("address", "shanghai");
		values.put("sex", "女");
		boolean flag=dao.update(values, "id=?", new String[]{"1"});
		System.out.println("---->"+flag);
	}
	
	
	
	public void viewDB(){
		Map<String, String> map=dao.viewPerson("id=?", new String[]{"1"});
		System.out.println("---->"+map.toString());
	}
	
	public void listDB(){
		List<Map<String, String>> list=dao.listPersonMaps(null, null);
		//select * from person
		System.out.println("---->"+list.toString());
	}
	

}
