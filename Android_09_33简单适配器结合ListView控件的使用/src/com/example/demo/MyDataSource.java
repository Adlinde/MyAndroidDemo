package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyDataSource {
	
	public static List<Map<String, Object>> getMaps(){
		
		List<Map<String, Object>> listMaps=new ArrayList<Map<String,Object>>();
	
		Map<String, Object> map1=new HashMap<String, Object>();
		map1.put("pname", "西瓜");
		map1.put("price", "$2.5");
		map1.put("address", "浙江");
		
		Map<String, Object> map2=new HashMap<String, Object>();
		map2.put("pname", "香蕉");
		map2.put("price", "$5.0");
		map2.put("address", "广西");
		
		
		Map<String, Object> map3=new HashMap<String, Object>();
		map3.put("pname", "苹果");
		map3.put("price", "$6.0");
		map3.put("address", "广州");
		
		listMaps.add(map1);
		listMaps.add(map2);
		listMaps.add(map3);
		
		return listMaps;
	
	
	}

}
