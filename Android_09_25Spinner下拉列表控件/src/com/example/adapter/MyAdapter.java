package com.example.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.R;



public class MyAdapter {
	
	private void Myadapter() {
		// TODO Auto-generated method stub

	}
	
	public static List<String> getData(){
		
		List<String> list=new ArrayList<String>();
		list.add("����");
		list.add("�Ϻ�");
		list.add("����");
		return list;
	}
	
	
	public static List<Map<String,Object>> getlistMaps(){
		
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		
		Map<String,Object> map=new HashMap<String, Object>();
		
		map.put("ivlogo",R.drawable.button2);
		map.put("applicationName","����");
		
		Map<String,Object> map2=new HashMap<String, Object>();
		
		map2.put("ivlogo",R.drawable.button2);
		map2.put("applicationName","eoemarket�ͻ���");
		
		list.add(map);
		list.add(map2);
		
		return list;
	}

}
