package com.pull.parser;

import java.io.InputStream;
import java.util.List;

import com.pull.entity.Person;



/**
 * 主要是使用PULL解析xml
 * @author 孙世东
 *
 */

public class PullXMLTools {

	public PullXMLTools() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param inputStream从服务器获取xml文件，以流的形式返回，
	 * @param encode编码格式
	 * @return
	 */
	public static List<Person> parserXML(InputStream inputStream,String encode){
		List<Person> list=null;//装载解析每一个person节点的内容
		
		//创建一个xml解析的工厂
		
		
		
		return list;
	}
	

}
