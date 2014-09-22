package com.example.demo.test;

import java.util.List;
import java.util.Map;

import android.test.AndroidTestCase;

import com.example.demo.dao.IPersonDao;
import com.example.demo.dao.impl.PersonDaoImpl;
import com.example.demo.db.DbopenHelper;

public class MyTest extends AndroidTestCase {

	public String TAG="MyTest";	
	public MyTest() {
		// TODO Auto-generated constructor stub
	}
	
	public void creatDb(){
		
		DbopenHelper helper= new DbopenHelper(getContext());
		helper.getWritableDatabase();
	}
	
	public void insertDB(){
		IPersonDao dao=new PersonDaoImpl(getContext());
		Object[] params={"����","����","��"};
		boolean flag=dao.add(params);
		System.out.println("---->"+flag);
	}
	
	public void delDB(){
		IPersonDao dao=new PersonDaoImpl(getContext());
		Object[] params={1};
		boolean flag=dao.del(params);
		System.out.println("---->"+flag);
	}
	
	public void updaDB(){
		IPersonDao dao=new PersonDaoImpl(getContext());
		Object[] params={"����","�Ϻ�","����","1"};
		boolean flag=dao.update(params);
		System.out.println("---->"+flag);
	}
	
	public void viewDB(){
		IPersonDao dao=new PersonDaoImpl(getContext());
		String[] params={"1"};
		Map<String, String> map=dao.viewPerson(params);
		System.out.println("---->"+map.toString());
	}
	
	public void listDB(){
		IPersonDao dao=new PersonDaoImpl(getContext());
		List<Map<String, String>> list=dao.listPersonMaps(null);
		System.out.println("---->"+list.toString());
	}
	

}
