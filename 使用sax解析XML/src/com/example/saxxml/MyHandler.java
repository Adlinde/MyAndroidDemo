package com.example.saxxml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.sax.StartElementListener;

public class MyHandler extends DefaultHandler {
	
	private HashMap<String, String> map=null;//存储单个解析的完整对象
	
	private List<HashMap<String, String>> list=null;//存储所以得解析对象
	
	private String currentTag=null;//正在解析元素的标签
	
	private String currentValue=null;//解析当前元素的值
	
	private String nodeName =null;//解析当前节点的名称
	
	
	public MyHandler(String nodename) {
		// TODO Auto-generated constructor stub
		this.nodeName=nodename;
	}
	
	public List<HashMap<String, String>> getList() {
		return list;
	}
	
	//解析开始文档触发
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		//当读取到第一个开始标签的时候会触发这个方法
		
		list=new ArrayList<HashMap<String,String>>();
		
		
		super.startDocument();
	}
	
	//解析开始元素触发
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		
		//当读取到文档开头的时候，调用这个方法
		
		if(qName.equals(nodeName)){
			
			map=new HashMap<String, String>();
		}
		
		if(attributes!=null && map!=null){
			for (int i = 0; i < attributes.getLength(); i++) {
				map.put(attributes.getQName(i), attributes.getValue(i));
			}
			
		}
		
		currentTag=qName;
	}
	
	//解析内容触发
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		//处理xml文件读取到的内容
		
		if(currentTag!=null&&map!=null){
			currentValue=new String(ch,start,length);
			if(currentValue!=null&&!currentValue.trim().equals("")
					&&currentValue.trim().equals("/n")){
				map.put(currentTag, currentValue);
			}
		}
		//把当前节点对应的值和标签设置为空
		currentTag=null;
		currentValue=null;
	}
	
	//解析完成触发
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		//遇到结束标记的时候调用
		
		if(qName.equals(nodeName)){
			list.add(map);
			map=null;
			
		}
		super.endElement(uri, localName, qName);
	}


	


}
