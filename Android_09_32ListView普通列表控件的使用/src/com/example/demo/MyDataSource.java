package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class MyDataSource {

	public MyDataSource() {
		// TODO Auto-generated constructor stub
	}
	
	
	public  static List<String> getDataSource(){
		
		List<String> list=new ArrayList<String>();
		list.add("北京");
		list.add("杭州");
		list.add("上海");
		list.add("广州");
		list.add("宁波");
		return list;
	}

}
